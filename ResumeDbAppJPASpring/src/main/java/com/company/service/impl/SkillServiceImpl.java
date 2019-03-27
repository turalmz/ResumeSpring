package com.company.service.impl;

import com.company.dao.impl.CountryRepositoryCostum;
import com.company.dao.impl.SkillRepositoryCostum;
import com.company.entity.Country;
import com.company.entity.Skill;
import com.company.service.inter.CountryServiceInter;
import com.company.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SkillServiceImpl implements SkillServiceInter {


    @Autowired
    @Qualifier("skillDao")
    private SkillRepositoryCostum skillDao;

    @Override
    public List<Skill> getAll() {
        return skillDao.getAll();
    }

    @Override
    public Skill getById(int userId) {
        return skillDao.getById(userId);
    }

    @Override
    public boolean addSkill(Skill u) {
        return  skillDao.insertSkill(u);
    }

    @Override
    public boolean updateSkill(Skill u) {
        return  skillDao.updateSkill(u);
    }

    @Override
    public boolean removeSkill(int id) {

        return skillDao.removeSkill(id);
    }

}