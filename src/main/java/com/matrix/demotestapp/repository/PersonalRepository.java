package com.matrix.demotestapp.repository;

import com.matrix.demotestapp.model.Person;

import java.util.List;

public interface PersonalRepository {
    String selectPersonById(int id);
    List<Person> selectAll();
    boolean setPerson(Person person);
    boolean updatePerson(Person person);
    boolean deletePerson(int id);
}
