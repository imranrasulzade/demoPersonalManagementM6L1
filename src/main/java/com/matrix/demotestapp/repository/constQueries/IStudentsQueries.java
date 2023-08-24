package com.matrix.demotestapp.repository.constQueries;

public interface IStudentsQueries {
    String insert = "INSERT INTO students (name, surname) VALUES (:name, :surname)";
    String selectAll = "SELECT * FROM students;";
    String selectById = "SELECT * FROM students WHERE ID = :id";
    String update = "UPDATE students SET name = :name, surname = :surname WHERE id = :id";
    String delete = "DELETE FROM students WHERE id = :id";
}
