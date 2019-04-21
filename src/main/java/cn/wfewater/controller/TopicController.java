package cn.wfewater.controller;

import cn.wfewater.domain.Topic;
import cn.wfewater.domain.User;
import cn.wfewater.service.Impl.TopicServiceImpl;
import cn.wfewater.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class TopicController {
    @Autowired
    private TopicServiceImpl topicService;
    @Autowired
    private UserServiceImpl userService;
    //渲染首页
    @RequestMapping("/")
    public ModelAndView toMain(HttpSession httpSession) {
        User user = userService.getUserById((Integer)httpSession.getAttribute("userId"));
        List<Topic> topics = topicService.listTopicsAndUserInfo();
        ModelAndView modelAndView = new ModelAndView("cate");
        modelAndView.addObject("user",user);
        modelAndView.addObject("topics",topics);
        return modelAndView;
    }

    @RequestMapping("/topic/add")
    public ModelAndView topicCreate(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        //System.out.println("In topic add");
        ModelAndView tcmodelAndView;
        if(httpSession.getAttribute("userId")==null) {
            tcmodelAndView = new ModelAndView("signin");
            return tcmodelAndView;
        }
        Integer userId = (Integer) httpSession.getAttribute("userId");
        String content = httpServletRequest.getParameter("content");
        String title = httpServletRequest.getParameter("title");
        Topic topic = new Topic();
        topic.setContent(content);
        topic.setTitle(title);
        topic.setUserId(userId);
        topic.setCreateTime(new Date());
        topic.setUpdateTime(new Date());
//        int adres = topicService.add(topic);
//        System.out.println("adres=" + adres);
        tcmodelAndView = new ModelAndView("cate");
        return tcmodelAndView;
    }
}
