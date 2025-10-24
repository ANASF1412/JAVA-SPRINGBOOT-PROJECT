package com.example.demo.controller;

import com.example.demo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService helloService;

    // Constructor-based DI
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    // Greeting endpoint
    @GetMapping("/hello")
    public String sayHello() {
        return helloService.getGreeting();
    }

    // Addition endpoint
    @GetMapping("/add")
    public String addNumbers(@RequestParam int a, @RequestParam int b) {
        int result = helloService.add(a, b);
        return "Addition Result: " + result;
    }

    // Subtraction endpoint
    @GetMapping("/subtract")
    public String subtractNumbers(@RequestParam int a, @RequestParam int b) {
        int result = helloService.subtract(a, b);
        return "Subtraction Result: " + result;
    }
}
