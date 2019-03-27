package com.company;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserServiceInter userService;


    @RequestMapping(method = RequestMethod.GET, value="/login")//users?name=Sarkhan
    public ModelAndView index(){

        ModelAndView mv = new ModelAndView("login");
        return mv;
    }


    @RequestMapping(method = RequestMethod.POST, value="/login")//users?name=Sarkhan
    public ModelAndView post(
            @RequestParam(value="email", required = false) String email ,
            @RequestParam(value="password", required = false) String password){

        BCrypt.Verifyer verifyer = BCrypt.verifyer();

        User us = userService.findByEmail(email);
        if (us == null) {
            throw new IllegalArgumentException("User doesn't existt!!!");
        }

        BCrypt.Result rs = verifyer.verify(password.toCharArray(), us.getPassword().toCharArray());

        if(!rs.verified){
            throw new IllegalArgumentException("password is incorrect!!!");
        }

        ModelAndView mv = new ModelAndView("login");


        return mv;
    }
}