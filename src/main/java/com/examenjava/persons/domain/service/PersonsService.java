package com.examenjava.persons.domain.service;

import java.util.List;

import com.examenjava.gender.domain.entity.Gender;
import com.examenjava.persons.domain.entity.Persons;

public interface PersonsService {
    void createPersons(Persons persons);
    Persons findPersonsById(int id);
    void updatePersons(Persons personsUpdate, int id);
    void deletePersons(int id);
    List<Persons> getAllPersons();
}
