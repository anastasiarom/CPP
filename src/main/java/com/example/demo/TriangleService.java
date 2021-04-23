package com.example.demo;

import com.example.demo.validation.TriangleValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TriangleService {
    @Autowired
    Cache cache;
    Logger logger = LogManager.getLogger(TriangleValidation.class);

    private TriangleCalculator triangleCalculator = new TriangleCalculator();
    private TriangleValidation triangleValidation = new TriangleValidation();

    public TriangleParameters triangleService(Triangle triangle) {
        if (triangleValidation.isValid(triangle))
            if (cache.isAlreadyHashed(triangle)) {
                logger.info("The value is already saved in cache");
                cache.getParameters(triangle);
            }
        TriangleParameters parameters = new TriangleParameters(triangleCalculator.calculatePerimeter(triangle), triangleCalculator.calculateSquare(triangle));
        cache.addToCache(triangle, parameters);
        logger.info("The value was successfully saved to the cache");
        return parameters;
    }
}
