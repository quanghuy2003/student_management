package com.example.test.service;

import com.example.test.model.Student;

public interface IStudentService extends IService<Student> {
    Iterable<Student>findAllByName(String name);

}
