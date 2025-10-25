package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // READ all
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // READ by name
    public List<Student> getStudentByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }

    // FULL UPDATE
    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setAge(updatedStudent.getAge());
                    student.setEmail(updatedStudent.getEmail());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // PARTIAL UPDATE
    public Student partialUpdateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    if (updatedStudent.getName() != null) student.setName(updatedStudent.getName());
                    if (updatedStudent.getAge() != null) student.setAge(updatedStudent.getAge());
                    if (updatedStudent.getEmail() != null) student.setEmail(updatedStudent.getEmail());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // DELETE
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
