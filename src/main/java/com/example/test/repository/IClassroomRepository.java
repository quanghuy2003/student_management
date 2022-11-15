package com.example.test.repository;

import com.example.test.model.Classroom;
import com.example.test.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassroomRepository extends CrudRepository<Classroom, Long> {
}
