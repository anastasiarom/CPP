package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.InternalServerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class TriangleController {
    @Autowired
    Cache cache;
    Logger logger = LogManager.getLogger(TriangleController.class);

    @GetMapping("/")
    public TriangleParameters GetParam(@RequestParam(value = "side1", defaultValue = "5") Double side1,
                                       @RequestParam(value = "side2", defaultValue = "4") Double side2,
                                       @RequestParam(value = "side3", defaultValue = "3") Double side3) {

        Triangle triangle = new Triangle(side1, side2, side3);
        if (triangle.isInputCorrect()) {
            logger.info("Correct input:" + side1 + side2 + side3);
            if (triangle.isTriangleExist()) {
                logger.info("The triangle exists");
                TriangleParameters parameters;
                if (cache.isAlreadyHashed(triangle)) {
                    logger.info("The value is already saved in cache");
                    parameters = cache.getParameters(triangle);
                } else {
                    parameters = new TriangleParameters(triangle.calculatePerimeter(), triangle.calculateSquare());
                    cache.addToCache(triangle, parameters);
                    logger.info("The value was successfully saved to the cache");
                }
                return parameters;
            } else {
                logger.error("500 error!");
                throw new InternalServerException();
            }
        } else {
            logger.error("400 error!");
            throw new BadRequestException();
        }
    }
}