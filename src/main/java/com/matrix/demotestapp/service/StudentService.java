package com.matrix.demotestapp.service;

import com.matrix.demotestapp.model.Student;

import java.util.List;

public interface StudentService {
    Student get(Integer id);
    List<Student> getAll();

    Student add(Student student);

    Student update(Student student);

    void delete(Integer id);
}
