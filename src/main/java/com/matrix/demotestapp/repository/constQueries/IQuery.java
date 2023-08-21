package com.matrix.demotestapp.repository.constQueries;

public interface IQuery {
     String insertQuery = "INSERT INTO persons (name, surname, phone, address, status) VALUES (?, ?, ?, ?, ?);";
     String selectAllQuery = "SELECT * FROM persons;";
     String selectByIdQuery = "SELECT * FROM persons WHERE id = ?;";
     String updateQuery = "UPDATE persons SET name=?, surname=?, phone=?, address=?, status=? WHERE id=?";
     String deleteQuery = "DELETE FROM persons WHERE id = ?;";

}
