package com.example.demo.controllers;

import com.example.demo.counter.CounterThread;
import com.example.demo.counter.Synchronization;
import com.example.demo.entity.Triangle;
import com.example.demo.entity.TriangleParameters;
import com.example.demo.logic.TriangleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;


@RestController
public class TriangleController {
    @Autowired
    TriangleService service;
    CounterThread counterThread = new CounterThread();
    Logger logger = LogManager.getLogger(TriangleController.class);

    @GetMapping("/")
    public TriangleParameters GetParam(@RequestParam(value = "side1", defaultValue = "5") Double side1,
                                       @RequestParam(value = "side2", defaultValue = "4") Double side2,
                                       @RequestParam(value = "side3", defaultValue = "3") Double side3) {
        Synchronization.semaphore.release();
        Triangle triangle = new Triangle(side1, side2, side3);
        return service.triangleService(triangle);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String handleException() {
        logger.info("Visited handleException");
        return "/error/400.html";
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> postTriangle(@RequestBody List<Triangle> triangles) {
        List<TriangleParameters> triangleParameters = new LinkedList<>();
        triangles.forEach((currentElement) -> {
            try {
                triangleParameters.add(service.triangleService(currentElement));
            } catch (Exception e) {
                logger.error("Error in post");
            }
        });

        double averageSquare = service.calculateAverageSquare(triangleParameters);
        double averagePerimeter = service.calculateAveragePerimeter(triangleParameters);
        double minSquare = service.findMinSquare(triangleParameters);
        double maxSquare = service.findMaxSquare(triangleParameters);
        double minPerimeter = service.findMinPerimeter(triangleParameters);
        double maxPerimeter = service.findMaxPerimeter(triangleParameters);

        return new ResponseEntity<>(triangleParameters + "\nAverage perimeter value:  " + averagePerimeter +
                "\nAverage square value:  " + averageSquare +
                "\nMin perimeter:  " + minPerimeter + "\nMax perimeter:  " + maxPerimeter +
                "\nMin square:  " + minSquare + "\nMax square:  " + maxSquare, HttpStatus.OK);
    }


}