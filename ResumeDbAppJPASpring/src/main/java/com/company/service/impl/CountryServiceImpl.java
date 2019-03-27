package com.company.service.impl;

import com.company.dao.impl.CountryRepositoryCostum;
import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.service.inter.CountryServiceInter;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CountryServiceImpl implements CountryServiceInter {


    @Autowired
    @Qualifier("countryDao")
    private CountryRepositoryCostum countryDao;

    @Override
    public List<Country> getAll() {
        return countryDao.getAll();
    }

    @Override
    public Country getById(int userId) {
        return countryDao.getById(userId);
    }

    @Override
    public boolean addCountry(Country u) {

        return  countryDao.insertCountry(u);
    }

    @Override
    public boolean updateCountry(Country u) {
        return  countryDao.updateCountry(u);
    }

    @Override
    public boolean removeCountry(Integer id) {

        return countryDao.removeCountry(id);
    }

}