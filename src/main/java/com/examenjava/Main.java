package com.examenjava;

import com.examenjava.city.domain.service.CityService;
import com.examenjava.city.infrastructure.out.CityRepository;
import com.examenjava.common.infrastructure.in.MainUi;
import com.examenjava.gender.domain.service.GenderService;
import com.examenjava.gender.infrastructure.out.GenderRepository;
import com.examenjava.persons.domain.service.PersonsService;
import com.examenjava.persons.infrastructure.out.PersonsRepository;
import com.examenjava.skill.domain.service.SkillService;
import com.examenjava.skill.infrastructure.out.SkillRepository;

public class Main {
    public static void main(String[] args) {
        PersonsService personsService = new PersonsRepository();
        CityService cityService = new CityRepository();
        GenderService genderService = new GenderRepository();
        SkillService skillService = new SkillRepository();
        MainUi mainWindow = new MainUi(personsService, cityService, genderService , skillService);

        mainWindow.showMainUi();
    }
}