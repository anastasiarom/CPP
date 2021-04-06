package com.example.demo;

public class Triangle {

    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public boolean isTriangleExist() {
        return side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1;
    }

    public boolean isInputCorrect() {
        return side1 > 0 && side2 > 0 && side3 > 0;
    }

    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    public double calculateSquare() {
        double semiPerimeter = (side1 + side2 + side3) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        Double s1 = side1;
        Double s2 = side2;
        Double s3 = side3;
        result = prime * result + s1.hashCode();
        result = prime * result + s2.hashCode();
        result = prime * result + s3.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Triangle other = (Triangle) obj;
        if (side1 != other.side1)
            return false;
        if (side2 != other.side2)
            return false;
        if (side3 != other.side3)
            return false;
        return true;
    }
}