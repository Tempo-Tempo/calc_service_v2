package com.example.calcservice.triangle.model;

import lombok.Data;

@Data
public class RecTriangle extends Triangle {

    private final String keyRecArea = "recArea";
   public RecTriangle(double a, double b, double c, double h) {
       super(a, b, Math.sqrt(a*a + b*b), h);
   }

    @Override
    public double calcArea() {
        return getA() * getB() / 2;
    }
}
