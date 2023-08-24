package com.matrix.demotestapp.controller;

import com.matrix.demotestapp.model.Student;
import com.matrix.demotestapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController{

    private final StudentService studentService;

    @PostMapping("/")
    public ResponseEntity<Student> add(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("my-head", "test")
                .body(studentService.add(student));
    }

    @PutMapping("/")
    public Student update(@RequestBody Student student){
        return studentService.update(student);
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable Integer id){
        return studentService.get(id);
    }

    @GetMapping("/")
    public List<Student> getAll(){
        return studentService.getAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        studentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
