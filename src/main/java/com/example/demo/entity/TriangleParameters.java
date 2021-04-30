package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TriangleParameters {

    @JsonProperty("Triangle Perimeter")
    private double perimeter;
    @JsonProperty("Triangle Square")
    private double square;

    public TriangleParameters(double perimeter, double square) {
        this.perimeter = perimeter;
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public String toString() {
        return "{ " +
                "perimeter = " + perimeter +
                ", square = " + square +
                "}";
    }
}
