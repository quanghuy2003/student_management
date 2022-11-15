package com.example.test.repository;

import com.example.test.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends CrudRepository<Student,Long> {
    Iterable<Student>findAllByName(String name);

}
