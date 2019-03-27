package com.company.dao.impl;

import com.company.entity.Country;

import java.util.List;

public interface CountryRepositoryCostum {

    public List<Country> getAll();

    public Country getById(int id);

    public boolean insertCountry(Country u);

    public boolean updateCountry(Country u);

    public boolean removeCountry(int id);
}
