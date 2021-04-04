package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Cache {

    private HashMap<Triangle, TriangleParameters> cache;

    public Cache() {
        cache = new HashMap<>();
    }

    public boolean isAlreadyHashed(Triangle triangle) {
        return cache.containsKey(triangle);
    }

    public void addToCache(Triangle triangle, TriangleParameters parameters) {
        cache.put(triangle, parameters);
    }

    public TriangleParameters getParameters(Triangle triangle) {
        return cache.get(triangle);
    }
}
