/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.Skill;

import java.util.List;

/**
 *
 * @author TURAL
 */
public interface SkillRepositoryCostum {

    List<Skill> getAll();

    public Skill getById(int id);

    boolean updateSkill(Skill u);

    boolean removeSkill(int id);

    public boolean insertSkill(Skill skl);
}
