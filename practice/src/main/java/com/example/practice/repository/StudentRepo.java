package com.example.practice.repository;

import com.example.practice.entity.Student;
import com.example.practice.util.Pair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepo extends JpaRepository<Student, UUID> {

    List<Student> findByName(String name);
    @Query("SELECT COUNT(s) FROM Student s where s.name=:name")
    int countStudentByName(@Param("name") String name);
}
