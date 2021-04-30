package com.example.demo;

import com.example.demo.entity.Triangle;
import com.example.demo.entity.TriangleParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    /*void Square() {
        Triangle test = new Triangle(5, 4, 3);
        double expected = 6;

        double res = test.calculateSquare();

        Assertions.assertEquals(expected, res);
    }

    @Test
    void Perimeter() {
        Triangle test = new Triangle(5, 4, 3);
        double expected = 12;

        double res = test.calculatePerimeter();

        Assertions.assertEquals(expected, res);
    }

    @Test
    void Existence() {
        Triangle test = new Triangle(100, 4, 63);

        boolean res = test.isTriangleExist();

        Assertions.assertFalse(res);
    }


    void Input() {
        Triangle test = new Triangle(-5, -4, -3);

        boolean res1 = test.isInputCorrect();

        Assertions.assertFalse(res1);
    }
*/
    @Test
    void CacheTest() {

        Cache cache = new Cache();
        Triangle test = new Triangle(5, 4, 3);
        TriangleParameters testParam = new TriangleParameters(12, 6);

        cache.addToCache(test, testParam);
        boolean res1 = cache.isAlreadyHashed(test);

        Assertions.assertTrue(res1);
    }
}
