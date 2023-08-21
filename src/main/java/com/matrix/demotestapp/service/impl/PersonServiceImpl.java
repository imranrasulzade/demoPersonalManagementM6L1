package com.matrix.demotestapp.service.impl;

import com.matrix.demotestapp.model.Person;
import com.matrix.demotestapp.repository.PersonalRepository;
import com.matrix.demotestapp.service.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonalService {

    private final PersonalRepository personalRepository;

    @Override
    public String selectPersonById(int id){
        return personalRepository.selectPersonById(id);
    }

    @Override
    public List<Person> selectAll(){
        return personalRepository.selectAll();
    }

    @Override
    public boolean setPerson(Person person){
       return personalRepository.setPerson(person);
    }

    @Override
    public boolean updatePerson(Person person){
        return personalRepository.updatePerson(person);
    }

    @Override
    public boolean deletePerson(int id){
       return personalRepository.deletePerson(id);
    }
}
