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
            @RequestParam(value="name", required = false,defaultValue = "") String name,
            @RequestParam(value="surname", required = false,defaultValue = "") String surname,
            @RequestParam(value="nid", required = false, defaultValue = "") Integer nationalityId){
        if(name==""){name=null;}
        if(surname==""){surname=null;}

        List<User> list = userService.getAll(name, surname, nationalityId);
//        list.add(userService.getById(9));
//        list.add(userService.getById(10));
        ModelAndView mv = new ModelAndView("use");


        mv.addObject("list",list);
        return mv;
    }


    @RequestMapping(method = RequestMethod.POST, value="/users")//users?name=Sarkhan
    public ModelAndView post(
            @RequestParam(value="id", required = false) Integer Id,

            @RequestParam(value="action", required = false) String action){

        if(Id==null){

        }

        User user = null;
        if(action=="insert") {

            user = null;// new User(null,)
        }else if(action=="update") {
            user = userService.getById(Id);

            userService.updateUser(user);
        }else if (action.equals("delete")){
            System.err.println(Id);

            userService.removeUser(Id);
            System.err.println("deleted");
        }else{
            System.err.println(Id);
            System.err.println("no deleted");
            System.err.println(action);

        }



        List<User> list = userService.getAll(null, null, null);

        ModelAndView mv = new ModelAndView("use");


        mv.addObject("list",list);        return mv;
    }
}