package com.example.test.controller;

import com.example.test.model.Student;
import com.example.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping
    public ResponseEntity<Iterable<Student>> findAllStudent() {
        List<Student> students = (List<Student>) studentService.findAll();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> add(@RequestBody Student student) {
        student.setDateOfBirth(LocalDate.now());
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.findById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> student1 = studentService.findById(id);
        student.setId(student1.get().getId());
        studentService.save(student);
        return new ResponseEntity<>(student1.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.NOT_FOUND);
        }
        studentService.remove(id);
        return new ResponseEntity<>(student.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/name")
    public ResponseEntity<Iterable<Student>> searchByName( @RequestParam String name) {
        Iterable<Student> students = studentService.findAllByName(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
