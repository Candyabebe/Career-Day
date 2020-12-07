package com.sancom.careerday.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginController extends BaseController{
    @RequestMapping(value = {"/login", "/"})
    public ModelAndView login() {
        logger.info("we are in login page now");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        /*if (auth != null) {
            User user = userService.findUserByEmail(auth.getName());

            if (user != null) {
                return home();
            }
        }*/
        logger.info("we are in login page now");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;

    }

    @RequestMapping("registrationPage")
    public  ModelAndView redirectToRegitrationPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;

    }
}
