/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 *
 * @author TURAL
 */

@Repository
@Qualifier("userDao1")
public class UserRepositoryCustomImpl implements UserRepositoryCustom {


    @PersistenceContext
    EntityManager em;

    public List<User> getAll() {

        String jpql = "select u from User u ";

        Query query = em.createQuery(jpql, User.class);

        return query.getResultList();
    }


    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {

        String jpql = "select u from User u where 1=1";


        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.firstname=:name ";
        }

        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.lastname=:surname ";
        }

        if (nationalityId != null) {
            jpql += " and u.nationality.id=:nid";
        }

        Query query = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }

        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }

        if (nationalityId != null) {
            query.setParameter("nid", nationalityId);
        }

        return query.getResultList();
    }




    @Override
    public User getById(int userId) {

        String jpql = "select u from User u where 1=1";


        jpql += " and u.id=:userId ";

        Query query = em.createQuery(jpql, User.class);

        query.setParameter("userId", userId);


        List<User> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public boolean updateUser(User u) {
        em.merge(u);
        return true;
    }


    private static BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        em.persist(u);
        return true;
    }

    @Override
    public boolean removeUser(int id) {
        User u = em.find(User.class, id);
        em.remove(u);
        return true;
    }


    @Override
    public User findByEmail(String email) {
        Query q = em.createQuery("select u from User u where u.email= :e", User.class);
        q.setParameter("e", email);

        List<User> list = q.getResultList();//list=0

        if (list.size() == 1) {
            return list.get(0);
        }

        return null;
    }
}
