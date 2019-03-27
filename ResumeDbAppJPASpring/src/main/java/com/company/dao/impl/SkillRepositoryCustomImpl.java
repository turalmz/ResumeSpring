/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.Skill;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author TURAL
 */

@Repository
@Qualifier("skillDao")
public class SkillRepositoryCustomImpl implements SkillRepositoryCostum {


    @PersistenceContext
    EntityManager em;

    public List<Skill> getAll() {

        String jpql = "select u from Skill u ";

        Query query = em.createQuery(jpql, Skill.class);

        return query.getResultList();
    }



    @Override
    public Skill getById(int userId) {

        String jpql = "select u from Skill u where 1=1";


        jpql += " and u.id=:userId ";

        Query query = em.createQuery(jpql, Skill.class);

        query.setParameter("userId", userId);


        List<Skill> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public boolean updateSkill(Skill u) {
        em.merge(u);
        return true;
    }



    @Override
    public boolean removeSkill(int id) {
        Skill u = em.find(Skill.class, id);
        em.remove(u);
        return true;
    }


    @Override
    public boolean insertSkill(Skill skl) {
        em.persist(skl);
        return true;
    }


}
