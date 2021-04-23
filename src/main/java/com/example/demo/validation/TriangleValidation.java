package com.example.demo.validation;

import com.example.demo.Triangle;
import com.example.demo.validation.exceptions.BadRequestException;
import com.example.demo.validation.exceptions.InternalServerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleValidation {

    Logger logger = LogManager.getLogger(TriangleValidation.class);

    public boolean isValid(Triangle triangle) {
        if (triangle.getSide1() > 0 && triangle.getSide2() > 0 && triangle.getSide3() > 0) {
            logger.info("Correct input:" + triangle.getSide1() + triangle.getSide2() + triangle.getSide3());
            if (triangle.getSide1() + triangle.getSide2() > triangle.getSide3()
                    && triangle.getSide1() + triangle.getSide3() > triangle.getSide2()
                    && triangle.getSide2() + triangle.getSide3() > triangle.getSide1()) {
                logger.info("The triangle exists");
            } else {
                logger.error("500 error!");
                throw new InternalServerException();
            }
            return true;
        } else {
            logger.error("400 error!");
            throw new BadRequestException();
        }
    }
}
