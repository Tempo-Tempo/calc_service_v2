package com.example.calcservice.triangle.model;
import lombok.Data;

import java.util.Arrays;


@Data
public class RecTangle extends Triangle {

    private double weight;
    private double height;

    private final String keyRecArea = "recArea";

    public RecTangle(double a, double b) {
        this.weight = a;
        this.height = b;
    }


   //@Override
//    public double calcArea() {
//        double[] array = new double[]{a, b, c};
//        Arrays.sort(array);
//        double legSum = array[0] * array[1];
//        return legSum / 2;
//    }

}
