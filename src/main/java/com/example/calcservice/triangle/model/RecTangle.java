package com.example.calcservice.triangle.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Arrays;


@Data
@AllArgsConstructor
public class RecTangle extends Triangle {

    private double cos;
    private double sin;
    private double tang;

    public  RecTangle() {};
    public double calcSinRec() {
        double test = this.sin = Math.sin(angleA);
        System.out.println(Math.toDegrees(test) + " TEST SIN");
        return  Math.toRadians(test);
    }
    public double calcCosRec() {
        double test = this.cos = Math.cos(angleA);
        System.out.println(Math.toDegrees(test) + " TEST COS");
        return  Math.toRadians(test);
    }
    public double calcTanRec() {

        double test = this.tang = Math.tan(angleA);
        System.out.println(Math.toDegrees(test) + " TEST TANG");
        return Math.toRadians(test);
    }


}
