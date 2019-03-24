/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.Skill;
import com.company.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TURAL
 */
public interface UserDaoInter {
     
    List<User> getAll();

    List<User> getAll(String name, String surname, Integer nat);
     
    public User getById(int id);

    boolean addUser(User u);

    boolean updateUser(User u);
     
    boolean removeUser(int id);

    public User findByEmail(String email) ;

}
