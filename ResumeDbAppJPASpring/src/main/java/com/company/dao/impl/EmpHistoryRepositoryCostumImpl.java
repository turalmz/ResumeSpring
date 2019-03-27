/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EmpHistoryDaoInter;
import com.company.entity.Country;
import com.company.entity.EmploymentHistory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TURAL
 */
@Repository
@Qualifier("empHistoryDao")
public class EmpHistoryRepositoryCostumImpl implements EmpHistoryRepositoryCostum {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<EmploymentHistory> getAll() {
        String jpql = "select u from EmploymentHistory u ";

        Query query = em.createQuery(jpql, EmploymentHistory.class);

        return query.getResultList();
    }

    @Override
    public EmploymentHistory getById(int empId) {
        String jpql = "select u from EmploymentHistory u where 1=1";

        jpql += " and u.id=:empId ";

        Query query = em.createQuery(jpql, EmploymentHistory.class);

        query.setParameter("empId", empId);


        List<EmploymentHistory> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public boolean insertEmpHistory(EmploymentHistory u) {
        em.persist(u);
        return true;
    }

    @Override
    public boolean updateEmpHistory(EmploymentHistory u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean removeEmpHistory(int id) {
        EmploymentHistory u = em.find(EmploymentHistory.class, id);
        em.remove(u);
        return true;
    }
}
