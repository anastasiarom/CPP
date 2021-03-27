package com.example.demo;

public class Triangle {

    public double side1;
    public double side2;
    public double side3;
    public double square;
    public double perimeter;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public boolean CheckTriangle() {
        return side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1;
    }

    public void setPerimeter() {
        this.perimeter = side1 + side2 + side3;
    }

    public void setSquare() {
        this.square = Math.sqrt((perimeter / 2) * (perimeter / 2 - side1) * (perimeter / 2 - side2) * (perimeter / 2 - side3));
    }
}