package cn.wfewater.controller;

import cn.wfewater.domain.User;
import cn.wfewater.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller

public class UserController {
    @Autowired
    private UserServiceImpl userService;
    //测试用接口
    @RequestMapping("/user")
    public ModelAndView handleRequest() {
        System.out.println("Hello MVC");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message","Test OK");
        return modelAndView;
    }

    //注册
    @RequestMapping("/add")
    public String signUp(HttpServletRequest httpServletRequest) {
        System.out.println("In signUp");
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        String telNum = httpServletRequest.getParameter("tel");
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setTelNum(telNum);
        int isSucc = userService.add(user);
        System.out.println(isSucc);
        return "redirect:index";
    }


}
