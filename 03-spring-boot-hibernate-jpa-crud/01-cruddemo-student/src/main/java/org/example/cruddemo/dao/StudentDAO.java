package org.example.cruddemo.dao;

import org.example.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
}
