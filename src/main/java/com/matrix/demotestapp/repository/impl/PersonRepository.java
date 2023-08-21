package com.matrix.demotestapp.repository.impl;

import com.matrix.demotestapp.model.Person;
import com.matrix.demotestapp.repository.constQueries.IQuery;
import com.matrix.demotestapp.repository.PersonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonRepository implements PersonalRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public String selectPersonById(int id){
        String sql = IQuery.selectByIdQuery;
        Object[] params = {id};
        Person person = new Person();
        jdbcTemplate.query(sql, params, (rs, rowNum) -> {
            person.setId(rs.getInt(1));
            person.setName(rs.getString(2));
            person.setSurname(rs.getString(3));
            person.setPhone(rs.getString(4));
            person.setAddress(rs.getString(5));
            person.setStatus(rs.getInt(6));
            return person;
        });
        return person.toString();
    }

    @Override
    public List<Person> selectAll(){
        List<Person> persons = new ArrayList<>();
        String sql = IQuery.selectAllQuery;
        jdbcTemplate.query(sql, (rs, rowNum) -> {
            Person person = new Person();
            person.setId(rs.getInt(1));
            person.setName(rs.getString(2));
            person.setSurname(rs.getString(3));
            person.setPhone(rs.getString(4));
            person.setAddress(rs.getString(5));
            person.setStatus(rs.getInt(6));

            persons.add(person);
            return persons;
        });
        return persons;
    }

    @Override
    public boolean setPerson(Person person){
        String sql = IQuery.insertQuery;
        Object[] params = {person.getName(), person.getSurname(), person.getPhone(), person.getAddress(), person.getStatus()};

        int row = jdbcTemplate.update(sql, params);
        return row > 0;
    }

    @Override
    public boolean updatePerson(Person person){
        String sql = IQuery.updateQuery;
        Object[] params = {person.getName(), person.getSurname(), person.getPhone(), person.getAddress(), person.getStatus(), person.getId()};

        int row = jdbcTemplate.update(sql, params);
        return row > 0;
    }

    @Override
    public boolean deletePerson(int id){
        String sql = IQuery.deleteQuery;

        int row = jdbcTemplate.update(sql, id);
        return row > 0;
        }
}
