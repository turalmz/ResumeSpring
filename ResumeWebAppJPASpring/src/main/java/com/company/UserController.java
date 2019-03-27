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
            @RequestParam(value="name", required = false) String firstname ,
            @RequestParam(value="surname", required = false) String lastname,
            @RequestParam(value="profile", required = false) String profile,
            @RequestParam(value="address", required = false) String address,
            @RequestParam(value="phone", required = false) String phone,
            @RequestParam(value="password", required = false) String password,
            @RequestParam(value="email", required = false) String email,
            @RequestParam(value="nationality", required = false) Integer nationalityId,
            @RequestParam(value="country", required = false) Integer countryId,

            @RequestParam(value="action", required = false) String action){

        if(Id==null){

        }

        User us = userService.getById(Id);
        if(action=="add") {

            us = new User(0);

            us.setFirstname(firstname);

            us.setLastname(lastname);

            us.setProfileDescription(profile);

            String bcryptHashString = BCrypt.withDefaults().hashToString(4, password.toCharArray());

            us.setPassword(bcryptHashString);

            us.setAddress(address);

            us.setPhone(phone);

            us.setEmail(email);

            us.setBirthPlace(new Country(countryId));

            us.setNationality(new Country(nationalityId));

            userService.addUser(us);


            System.out.println("here we are");
            System.out.println("userdetail?id=" + us.getId());

        }else if(action=="update") {
            us = userService.getById(Id);

            us.setFirstname(firstname);

            us.setLastname(lastname);

            us.setProfileDescription(profile);

            String bcryptHashString = BCrypt.withDefaults().hashToString(4, password.toCharArray());

            us.setPassword(bcryptHashString);

            us.setAddress(address);

            us.setPhone(phone);

            us.setEmail(email);

            us.setBirthPlace(new Country(countryId));

            us.setNationality(new Country(nationalityId));
            userService.updateUser(us);
        }else if (action.equals("delete")){
            System.err.println(Id);

            userService.removeUser(Id);
            System.err.println("deleted");
        }else{

        }



        List<User> list = userService.getAll(null, null, null);

        ModelAndView mv = new ModelAndView("use");


        mv.addObject("list",list);        return mv;
    }
}