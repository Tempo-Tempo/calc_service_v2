package com.example.calcservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public  class Figure {
    private double a;
    private double b;
    private double c;
    private double h;

    public Figure() {};

    private final String keyArea = "area";
    private final String keyPer = "per";

}
