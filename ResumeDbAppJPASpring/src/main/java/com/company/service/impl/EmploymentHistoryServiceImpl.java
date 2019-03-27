package com.company.service.impl;

import com.company.dao.impl.EmpHistoryRepositoryCostum;
import com.company.dao.impl.SkillRepositoryCostum;
import com.company.entity.EmploymentHistory;
import com.company.entity.Skill;
import com.company.service.inter.EmploymentHistoryServiceInter;
import com.company.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class EmploymentHistoryServiceImpl implements EmploymentHistoryServiceInter {


    @Autowired
    @Qualifier("empHistoryDao")
    private EmpHistoryRepositoryCostum empHistoryDao;

    @Override
    public List<EmploymentHistory> getAll() {
        return empHistoryDao.getAll();
    }

    @Override
    public EmploymentHistory getById(int userId) {
        return empHistoryDao.getById(userId);
    }

    @Override
    public boolean addEmploymentHistory(EmploymentHistory u) {
        return  empHistoryDao.insertEmpHistory(u);
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory u) {
        return  empHistoryDao.updateEmpHistory(u);
    }

    @Override
    public boolean removeEmploymentHistory(int id) {

        return empHistoryDao.removeEmpHistory(id);
    }

}