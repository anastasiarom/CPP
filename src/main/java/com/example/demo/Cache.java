package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Cache {

    private HashMap<Triangle, TriangleParameters> cache;

    public Cache() {
        cache = new HashMap<>();
    }

    public boolean isAlreadyHashed(Triangle key) {
        return cache.containsKey(key);
    }

    public void addToCache(Triangle key, TriangleParameters parameters) {
        cache.put(key, parameters);
    }

    public TriangleParameters getParameters(Triangle key) {
        return cache.get(key);
    }
}
