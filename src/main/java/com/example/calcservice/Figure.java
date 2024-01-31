package com.example.calcservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Figure {
    protected double a;
    protected double b;
    protected double c;
    protected final double pi = 3.14;

    public Figure() {}

    private final String keyArea = "area";
    private final String keyPer = "per";

    public abstract double calcArea();
    public abstract double calcPer();
}
