package com.matrix.demotestapp.repository.impl;

import com.matrix.demotestapp.model.Student;
import com.matrix.demotestapp.repository.StudentDao;
import com.matrix.demotestapp.repository.constQueries.IStudentsQueries;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public Student get(Integer id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        return namedParameterJdbcTemplate.queryForObject(IStudentsQueries.selectById, namedParameters, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("ID"));
            student.setName(rs.getString("name"));
            student.setSurname(rs.getString("surname"));
            return student;
        });
    }

    @Override
    public List<Student> getAll(){
        return namedParameterJdbcTemplate.query(IStudentsQueries.selectAll,(rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("ID"));
            student.setName(rs.getString("name"));
            student.setSurname(rs.getString("surname"));
            return student;
        });
    }
    @Override
    public Student add(Student student) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("name", student.getName())
                .addValue("surname", student.getSurname());
        namedParameterJdbcTemplate.update(IStudentsQueries.insert, namedParameters);
        return student;
    }

    @Override
    public Student update(Student student) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("name", student.getName())
                .addValue("surname", student.getSurname())
                .addValue("id", student.getId());
        namedParameterJdbcTemplate.update(IStudentsQueries.update, namedParameters);
        return student;
    }

    @Override
    public void delete(Integer id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", id);
        if(namedParameterJdbcTemplate.update(IStudentsQueries.delete, namedParameters) > 0)
            System.out.println("1 row deleted");
        else
            System.out.println("process failed");
    }
}
