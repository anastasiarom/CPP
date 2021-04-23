package com.example.demo;

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

}
