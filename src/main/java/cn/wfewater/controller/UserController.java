package cn.wfewater.controller;

import javax.servlet.http.HttpServletRequest;

import cn.wfewater.domain.User;
import org.springframework.ui.Model;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    //private static Logger logger = LoggerFactory.getLogger(UserController.class);
    //@RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(HttpServletRequest httpServletRequest, Model model) {
        int userId = Integer.parseInt(httpServletRequest.getParameter("id"));
        System.out.println("userid="+userId);
        User user = new User();
        if(userId == 1) {
            user.setId(1);
            user.setUserName("testUser");
            user.setPassword("123456");
        }
        //logger.debug(user.toString());
        model.addAttribute("user",user);
        return "index";

    }



}
