package com.example.calcservice.triangle.model;
import lombok.Data;

import java.util.Arrays;


@Data
public class RecTriangle extends Triangle {

    private final String keyRecArea = "recArea";
   public RecTriangle(double a, double b, double c) {
       super(a, b, c);
   }
    @Override
    public double calcArea() {
        double[] array = new double[]{a, b, c};
        Arrays.sort(array);
        double legSum = array[0] * array[1];
        return legSum / 2;
    }

}
