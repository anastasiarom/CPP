package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    void Square() {
        Triangle test = new Triangle(5, 4, 3);
        double expected = 6;

        double res1 = test.CalculateSquare();

        Assertions.assertEquals(expected, res1);
    }

    @Test
    void Perimeter() {
        Triangle test = new Triangle(5, 4, 3);
        double expected = 12;

        double res1 = test.CalculatePerimeter();

        Assertions.assertEquals(expected, res1);
    }

    @Test
    void Existence() {
        Triangle test = new Triangle(100, 4, 63);
        boolean expected = false;

        boolean res1 = test.IsTriangleExist();

        Assertions.assertEquals(expected, res1);
    }

    @Test
    void Input() {
        Triangle test = new Triangle(-5, -4, -3);
        boolean expected = false;

        boolean res1 = test.IsInputCorrect();

        Assertions.assertEquals(expected, res1);
    }
}
