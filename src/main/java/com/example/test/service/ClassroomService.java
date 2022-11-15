package com.example.test.service;

import com.example.test.model.Classroom;
import com.example.test.repository.IClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassroomService implements IClassroomService {
    @Autowired
    private IClassroomRepository classroomRepository;
    @Override
    public void save(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    @Override
    public Iterable<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Optional<Classroom> findById(Long id) {
        return classroomRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        classroomRepository.deleteById(id);
    }
}
