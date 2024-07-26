package com.examenjava.skill.domain.service;


import java.util.List;

import com.examenjava.skill.domain.entity.Skill;

public interface SkillService {
    void createSkill(Skill skill);
    List<Skill> getAllSkills();
}
