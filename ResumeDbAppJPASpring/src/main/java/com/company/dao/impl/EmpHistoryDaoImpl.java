/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EmpHistoryDaoInter;
import com.company.entity.EmploymentHistory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TURAL
 */
public class EmpHistoryDaoImpl implements EmpHistoryRepositoryCostum {


    @Override
    public List<EmploymentHistory> getAll() {
        return null;
    }

    @Override
    public EmploymentHistory getById(int id) {
        return null;
    }

    @Override
    public boolean insertEmpHistory(EmploymentHistory u) {
        return false;
    }

    @Override
    public boolean updateEmpHistory(EmploymentHistory u) {
        return false;
    }

    @Override
    public boolean removeEmpHistory(int id) {
        return false;
    }
}
