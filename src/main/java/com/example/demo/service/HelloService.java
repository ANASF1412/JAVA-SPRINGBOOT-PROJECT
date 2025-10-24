package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getGreeting() {
        return "Hello! Welcome To Spring Boot + Dependency Injection!";
    }

    // Addition
    public int add(int a, int b) {
        return a + b;
    }

    // Subtraction
    public int subtract(int a, int b) {
        return a - b;
    }
}
