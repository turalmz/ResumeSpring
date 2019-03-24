/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.inter;

import com.company.entity.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


public interface UserServiceInter {

    public List<User> getAll(String firstname, String lastname, Integer nationalityId);

    public User getById(int id);

    public boolean addUser(User u);

    public boolean updateUser(User u);

    public boolean removeUser(Integer id);

    public User findByEmail(String email);


}