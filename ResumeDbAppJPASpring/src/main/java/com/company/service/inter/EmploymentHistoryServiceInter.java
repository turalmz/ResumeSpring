/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.inter;

import com.company.entity.EmploymentHistory;

import java.util.List;

/**
 *
 * @author TURAL
 */
public interface EmploymentHistoryServiceInter {

    List<EmploymentHistory> getAll();

    public EmploymentHistory getById(int id);

    public boolean addEmploymentHistory(EmploymentHistory u);

    boolean updateEmploymentHistory(EmploymentHistory u);

    boolean removeEmploymentHistory(int id);

}
