package cn.wfewater.controller;

import cn.wfewater.domain.User;
import cn.wfewater.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
        String username = httpServletRequest.getParameter("username");
        int loginSucc = userService.login(username,password);
        HashMap<String,String> res = new HashMap<String, String>();
        if (loginSucc==2) {
            User user = userService.getUserByName(username);
            Integer uid = user.getId();
            httpSession.setAttribute("userId",uid);
            httpSession.setAttribute("username",username);
            res.put("stateCode","2");
        }else if (loginSucc==1) {
            res.put("stateCode","1");
        }else {
            res.put("stateCode","0");
        }
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
    //用户个人中心
    @RequestMapping("/member/{username}")
    public ModelAndView perInfo(@PathVariable("username")String username, HttpSession httpSession) {
        System.out.println("In personal");
        String errorInfo = "会员未找到";
        boolean isExist = userService.existUsername(username);
        System.out.println("isExist="+isExist);
        ModelAndView pimodelAndView = new ModelAndView("user_info");
        User user = userService.getUserById((Integer)httpSession.getAttribute("uid"));
        if (isExist) {
            User resuser = userService.getUserByName("username");
            System.out.println("username"+resuser.getUserName()+" uid" + resuser.getId());
            pimodelAndView.addObject("userInfo",resuser);
            pimodelAndView.addObject("user",user);
            return  pimodelAndView;
        }else {
            pimodelAndView.addObject("errorInfo",errorInfo);
            return  pimodelAndView;
        }

    }

}
