package com.company.dao.impl;

import com.company.entity.User;

import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
public interface UserRepositoryCustom {

    public List<User> getAll(String name, String surname, Integer nationalityId);

    public User getById(int id);

    public boolean addUser(User u);

    public boolean updateUser(User u);

    public boolean removeUser(int id);

    public User findByEmail(String email);

}