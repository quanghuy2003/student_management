package com.example.test.controller;

import com.example.test.model.Classroom;
import com.example.test.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/classrooms")
public class ClassroomController {
    @Autowired
    ClassroomService classroomService;
    @GetMapping
    public ResponseEntity<Iterable<Classroom>> findByClass() {
        List<Classroom> classrooms = (List<Classroom>) classroomService.findAll();
        if (classrooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }
}
