package cn.wfewater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class TopicController {
    //渲染首页
    @RequestMapping("/")
    public ModelAndView toMain(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("cate");
        return modelAndView;
    }
}
