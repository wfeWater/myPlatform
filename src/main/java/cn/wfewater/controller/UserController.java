package cn.wfewater.controller;

import cn.wfewater.domain.User;
import cn.wfewater.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

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
        return "redirect:/";
    }
    //登录
    @RequestMapping("/loginCheck")
    @ResponseBody
    public Object signin(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        System.out.println("In loginCheck");
        String password = httpServletRequest.getParameter("password");
        System.out.println("password=" + password);
        String username = httpServletRequest.getParameter("username");
        System.out.println("username="+ username);
        int loginSucc = userService.login(username,password);
        System.out.println("loginSucc="+loginSucc);
        HashMap<String,String> res = new HashMap<String, String>();
        if (loginSucc==2) {
            User user = userService.getUserByName(username);
            System.out.println("username"+user.getUserName());
            Integer uid = user.getId();
            httpSession.setAttribute("userId",uid);
            httpSession.setAttribute("username",username);
            res.put("stateCode","2");
        }else if (loginSucc==1) {
            res.put("stateCode","1");
        }else {
            res.put("stateCode","0");
        }
        System.out.println("res="+res.get("stateCode"));
        return res;
    }

    //用户登出
    @RequestMapping("/signout")
    public String signout(HttpSession httpSession) {
        httpSession.removeAttribute("userId");
        httpSession.removeAttribute("username");
        return "redirect:/";
    }

    //用户设置
    @RequestMapping("/settings")
    public ModelAndView setting(HttpServletRequest httpServletRequest,HttpSession httpSession) {
        System.out.println("in setting");
        Integer uid = (Integer) httpSession.getAttribute("userId");
        User user = userService.getUserById(uid);


        ModelAndView stmodelAndView = new ModelAndView("settings");
        stmodelAndView.addObject("user",user);
        return  stmodelAndView;
    }
    //新建帖子


}
