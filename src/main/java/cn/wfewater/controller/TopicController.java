package cn.wfewater.controller;

import cn.wfewater.domain.Topic;
import cn.wfewater.service.Impl.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TopicController {
    @Autowired
    private TopicServiceImpl topicService;
    //渲染首页
    @RequestMapping("/")
    public ModelAndView toMain(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("cate");
        return modelAndView;
    }

    @RequestMapping("/topic/add")
    public ModelAndView topicCreate(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        System.out.println("In topic add");
        ModelAndView tcmodelAndView = null;
        if(httpSession.getAttribute("userId")==null) {
            tcmodelAndView = new ModelAndView("signin");
            return tcmodelAndView;
        }
        String content = httpServletRequest.getParameter("content");
        String title = httpServletRequest.getParameter("title");
        Topic topic = new Topic();
        topic.setContent(content);
        topic.setTitle(title);
        topicService.add(topic);

        return tcmodelAndView;
    }
}
