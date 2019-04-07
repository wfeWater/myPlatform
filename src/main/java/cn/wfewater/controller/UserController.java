package cn.wfewater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller

public class UserController {
    @RequestMapping("/user")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println("Hello MVC");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message","Test OK");
        return modelAndView;
    }


}
