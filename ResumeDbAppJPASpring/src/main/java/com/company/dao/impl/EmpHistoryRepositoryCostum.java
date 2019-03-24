/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.EmploymentHistory;

import java.util.List;

/**
 *
 * @author TURAL
 */
public interface EmpHistoryRepositoryCostum {

    List<EmploymentHistory> getAll();

    public EmploymentHistory getById(int id);

    public boolean insertEmpHistory(EmploymentHistory u);

    boolean updateEmpHistory(EmploymentHistory u);

    boolean removeEmpHistory(int id);

}
