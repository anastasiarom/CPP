package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public Triangle tr(@RequestParam(value = "side1", defaultValue = "0") Long side1, @RequestParam(value = "side2", defaultValue = "0") Long side2, @RequestParam(value = "side3", defaultValue = "0") Long side3) {
        return new Triangle(side1, side2, side3);
    }
}