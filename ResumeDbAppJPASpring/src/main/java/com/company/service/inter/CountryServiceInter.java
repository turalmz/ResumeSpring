/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.inter;

import com.company.entity.Country;
import com.company.entity.User;

import java.util.List;


public interface CountryServiceInter {

    public List<Country> getAll();

    public Country getById(int id);

    public boolean addCountry(Country u);

    public boolean updateCountry(Country u);

    public boolean removeCountry(Integer id);

}