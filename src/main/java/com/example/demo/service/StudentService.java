package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Constructor-based Dependency Injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // READ all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // READ student(s) by name (case-insensitive, partial match)
    public List<Student> getStudentByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    // UPDATE
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    // DELETE
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
