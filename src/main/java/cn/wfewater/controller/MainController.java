package cn.wfewater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @RequestMapping("/signin")
    public ModelAndView signin() {
        System.out.println("In signin");
        ModelAndView simodelAndView = new ModelAndView("signin");
        return simodelAndView;
    }
    @RequestMapping("/signup")
    public ModelAndView signup() {
        System.out.println("In signup");
        ModelAndView sumodelAndView = new ModelAndView("signup");
        return sumodelAndView;
    }
    @RequestMapping("/new")
    public ModelAndView create() {
        System.out.println("In new");
        ModelAndView nmodelAndView = new ModelAndView("new");
        return nmodelAndView;
    }
}
