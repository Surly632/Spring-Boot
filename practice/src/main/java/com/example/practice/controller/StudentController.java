package com.example.practice.controller;

import com.example.practice.entity.Student;
import com.example.practice.service.StudentService;
import com.example.practice.util.Pair;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@RestController
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody  Student st) {
        System.out.println(st);
        return service.saveStudent(st);
    }
    @PostMapping("/count")
    public List<Pair> countByName(@RequestBody Student st) {
        return service.countByName(st.getName());
    }

}
