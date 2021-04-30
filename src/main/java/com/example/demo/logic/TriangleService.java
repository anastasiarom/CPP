package com.example.demo.logic;

import com.example.demo.Cache;
import com.example.demo.entity.Triangle;
import com.example.demo.entity.TriangleParameters;
import com.example.demo.validation.TriangleValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TriangleService {
    @Autowired
    Cache cache;
    Logger logger = LogManager.getLogger(TriangleService.class);

    private TriangleCalculator triangleCalculator = new TriangleCalculator();
    private TriangleValidation triangleValidation = new TriangleValidation();

    public TriangleParameters triangleService(Triangle triangle) {
        if (triangleValidation.isValid(triangle))
            if (cache.isAlreadyHashed(triangle)) {
                logger.info("The value is already saved in cache");
                return cache.getParameters(triangle);
            }
        TriangleParameters parameters = new TriangleParameters(triangleCalculator.calculatePerimeter(triangle), triangleCalculator.calculateSquare(triangle));
        cache.addToCache(triangle, parameters);
        logger.info("The value was successfully saved to the cache");
        return parameters;
    }

    public double calculateAveragePerimeter(List<TriangleParameters> triangleParameters) {
        double averagePerimeter = 0;
        if (!triangleParameters.isEmpty()) {
            averagePerimeter = triangleParameters.stream().mapToDouble(TriangleParameters::getPerimeter).sum();
            averagePerimeter = averagePerimeter / triangleParameters.size();
        }
        return averagePerimeter;
    }

    public double calculateAverageSquare(List<TriangleParameters> triangleParameters) {
        double averageSquare = 0;
        if (!triangleParameters.isEmpty()) {
            averageSquare = triangleParameters.stream().mapToDouble(TriangleParameters::getSquare).sum();
            averageSquare = averageSquare / triangleParameters.size();
        }
        return averageSquare;
    }

    public double findMinPerimeter(List<TriangleParameters> triangleParameters) {
        double min = 0;
        if (!triangleParameters.isEmpty()) {
            min = triangleParameters.stream().mapToDouble(TriangleParameters::getPerimeter).min().getAsDouble();
        }
        return min;
    }

    public double findMaxPerimeter(List<TriangleParameters> triangleParameters) {
        double max = 0;
        if (!triangleParameters.isEmpty()) {
            max = triangleParameters.stream().mapToDouble(TriangleParameters::getPerimeter).max().getAsDouble();
        }
        return max;
    }

    public double findMinSquare(List<TriangleParameters> triangleParameters) {
        double min = 0;
        if (!triangleParameters.isEmpty()) {
            min = triangleParameters.stream().mapToDouble(TriangleParameters::getSquare).min().getAsDouble();
        }
        return min;
    }

    public double findMaxSquare(List<TriangleParameters> triangleParameters) {
        double max = 0;
        if (!triangleParameters.isEmpty()) {
            max = triangleParameters.stream().mapToDouble(TriangleParameters::getSquare).max().getAsDouble();
        }
        return max;
    }
}
