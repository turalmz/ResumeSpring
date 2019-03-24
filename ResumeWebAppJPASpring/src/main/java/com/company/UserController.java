package com.company;

import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceInter userService;


    @RequestMapping(method = RequestMethod.GET, value="/users")//users?name=Sarkhan
    public ModelAndView index(
            @RequestParam(value="name", required = false,defaultValue = "Pala") String name,
            @RequestParam(value="surname", required = false,defaultValue = "Katibov") String surname,
            @RequestParam(value="nid", required = false, defaultValue = "1") Integer nationalityId){
        List<User> list = userService.getAll(null, null, 1);
//        list.add(userService.getById(9));
//        list.add(userService.getById(10));
        ModelAndView mv = new ModelAndView("use");


        mv.addObject("list",list);
        return mv;
    }

}