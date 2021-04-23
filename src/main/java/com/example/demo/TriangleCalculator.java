package com.example.demo;

public class TriangleCalculator {
    public double calculatePerimeter(Triangle triangle) {
        return triangle.getSide1() + triangle.getSide2() + triangle.getSide3();
    }

    public double calculateSquare(Triangle triangle) {
        double semiPerimeter = (triangle.getSide1() + triangle.getSide2() + triangle.getSide3()) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - triangle.getSide1()) * (semiPerimeter - triangle.getSide2()) * (semiPerimeter - triangle.getSide3()));
    }
}
