package com.matrix.demotestapp.service.impl;

import com.matrix.demotestapp.model.Student;
import com.matrix.demotestapp.repository.StudentDao;
import com.matrix.demotestapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    @Override
    public Student get(Integer id) {
        return studentDao.get(id);
    }
    @Override
    public List<Student> getAll(){
        return studentDao.getAll();
    }
    @Override
    public Student add(Student student) {
        return studentDao.add(student);
    }

    @Override
    public Student update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public void delete(Integer id) {
        studentDao.delete(id);
    }
}
