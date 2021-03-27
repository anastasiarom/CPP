package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void Square() {
        Triangle test = new Triangle(5, 4, 3);
        double expected = 6;

        test.setSquare();
        double res1 = test.square;

        Assertions.assertEquals(expected, res1);
    }

    @Test
    void Perimeter() {
        Triangle test = new Triangle(5, 4, 3);
        double expected = 12;

        test.setPerimeter();
        double res1 = test.perimeter;

        Assertions.assertEquals(expected, res1);
    }
}
