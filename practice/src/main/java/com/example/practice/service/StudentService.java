package com.example.practice.service;

import com.example.practice.entity.Student;
import com.example.practice.repository.StudentRepo;
import com.example.practice.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;
    public List<Student> findByName(String name) {
        return repo.findByName(name);
    }

    public Optional<Student> getStudent(UUID id) {
        return repo.findById(id);
    }

    public ResponseEntity<Student> saveStudent(Student student) {
        Student saved = repo.save(student);
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }
    public ResponseEntity<List<Student>> saveStudents(List<Student> students) {
        List<Student> savedStudents = repo.saveAll(students);
        return new ResponseEntity<>(savedStudents, HttpStatus.CREATED);
    }

    public List<Pair> countByName(String name) {
        Integer total = repo.countStudentByName(name);
        ArrayList<Pair> v = new ArrayList<Pair>();
       v.add(new Pair(true,total,HttpStatus.OK.value()));

        return v;
    }


}
