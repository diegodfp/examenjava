package com.examenjava.persons.domain.service;

import com.examenjava.persons.domain.entity.Persons;

public interface PersonsService {
    void createPersons(Persons persons);
    Persons findPersonsById(int id);
    void updatePersons(Persons personsUpdate);
    void deletePersons(int id);
}
