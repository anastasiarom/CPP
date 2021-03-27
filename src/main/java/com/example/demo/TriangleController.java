package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@RestController
public class TriangleController {

    @GetMapping("/")
    public Triangle GetParam(@RequestParam(value = "side1", defaultValue = "5") Double side1,
                             @RequestParam(value = "side2", defaultValue = "4") Double side2,
                             @RequestParam(value = "side3", defaultValue = "3") Double side3) {
        Logger logger = LogManager.getLogger(TriangleController.class);
        Triangle figure= new Triangle(side1,side2,side3);
        if(figure.CheckTriangle()){
            logger.info("Successfully");
            figure.setPerimeter();
            figure.setSquare();
            return figure;
        }
        else{
            logger.info("400 error!");
            throw new BadRequestException();
        }
    }


}