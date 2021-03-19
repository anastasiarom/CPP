package com.example.demo;

public class Triangle {

    public long side1;
    public long side2;
    public long side3;
    public double square;
    public long perimeter;

    public Triangle(long side1, long side2, long side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side2 = side3;
        this.side3 = side3;
        perimeter = side1 + side2 + side3;
        square = Math.sqrt((perimeter / 2) * (perimeter / 2 - side1) * (perimeter / 2 - side2) * (perimeter / 2 - side3));
    }
}