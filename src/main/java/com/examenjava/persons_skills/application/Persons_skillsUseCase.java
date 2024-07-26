package com.examenjava.persons_skills.application;

import com.examenjava.persons_skills.infrastructure.out.Persons_skillRepository;

public class Persons_skillsUseCase {
    private final Persons_skillRepository persons_skillRepository;

    public Persons_skillsUseCase(Persons_skillRepository persons_skillRepository) {
        this.persons_skillRepository = persons_skillRepository;
    }
    
    
}
