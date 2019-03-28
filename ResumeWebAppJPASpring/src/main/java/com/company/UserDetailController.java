package com.company;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.Country;
import com.company.entity.EmploymentHistory;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.service.inter.CountryServiceInter;
import com.company.service.inter.EmploymentHistoryServiceInter;
import com.company.service.inter.SkillServiceInter;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserDetailController {

    @Autowired
    private UserServiceInter userService;


    @Autowired
    private SkillServiceInter skillService;


    @Autowired
    private CountryServiceInter countryService;

    @Autowired
    private EmploymentHistoryServiceInter employmentHistoryService;

    @RequestMapping(method = RequestMethod.GET, value="/userdetail")//users?name=Sarkhan
    public ModelAndView index(
            @RequestParam(value="id", required = false) Integer Id){


        User us = userService.getById(Id);

        ModelAndView mv = new ModelAndView("user");

        List<Country> countryList = countryService.getAll();
        List<Skill> skillList = skillService.getAll();
        List<EmploymentHistory> employmentHistoryList = employmentHistoryService.getAll();
        mv.addObject("user",us);
        mv.addObject("countryList",countryList);
        mv.addObject("skillList",skillList);
        mv.addObject("employmentHistoryList",employmentHistoryList);
        return mv;
    }



}