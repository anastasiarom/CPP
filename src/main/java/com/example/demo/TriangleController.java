package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.validation.exceptions.BadRequestException;
import com.example.demo.validation.exceptions.InternalServerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class TriangleController {
    Logger logger = LogManager.getLogger(TriangleController.class);
    @Autowired
    TriangleService service;
    @GetMapping("/")
    public TriangleParameters GetParam(@RequestParam(value = "side1", defaultValue = "5") Double side1,
                                       @RequestParam(value = "side2", defaultValue = "4") Double side2,
                                       @RequestParam(value = "side3", defaultValue = "3") Double side3) {

        Triangle triangle = new Triangle(side1, side2, side3);
        return service.triangleService(triangle);
    }
}