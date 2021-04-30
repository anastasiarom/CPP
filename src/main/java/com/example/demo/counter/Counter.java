package com.example.demo.counter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Counter {
    @JsonProperty("Number of service request")
    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public static void increment() {
        count++;
    }
}
