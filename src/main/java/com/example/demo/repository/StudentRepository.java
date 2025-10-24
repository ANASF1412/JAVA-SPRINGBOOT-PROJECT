package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Find exact name match
    List<Student> findByName(String name);

    // Find name containing part of the text, ignoring case
    List<Student> findByNameContainingIgnoreCase(String name);
}
