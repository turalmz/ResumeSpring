/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.Country;
import com.company.entity.EmploymentHistory;
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
@Qualifier("countryDao")
public class CountryRepositoryCostumImpl implements CountryRepositoryCostum {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Country> getAll() {

        String jpql = "select u from Country u ";

        Query query = em.createQuery(jpql, Country.class);

        return query.getResultList();
    }

    @Override
    public Country getById(int countryId) {
        String jpql = "select u from Country u where 1=1";

        jpql += " and u.id=:countryId ";

        Query query = em.createQuery(jpql, Country.class);

        query.setParameter("countryId", countryId);


        List<Country> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public boolean insertCountry(Country u) {
        em.persist(u);

        return true;
    }

    @Override
    public boolean updateCountry(Country u) {
        em.merge(u);

        return true;
    }

    @Override
    public boolean removeCountry(int id) {
        Country u = em.find(Country.class, id);
        em.remove(u);
        return true;
    }
}
