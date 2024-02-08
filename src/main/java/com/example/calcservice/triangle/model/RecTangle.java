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
        double angleA = Math.toRadians(this.angleA);
//        double angleB = Math.toRadians(this.angleB);
//        double angleC = Math.toRadians(this.angleC);
        double test = this.sin = Math.sin(angleA);
        System.out.println(test + " TEST SIN");
        return  test;
    }
    public double calcCosRec() {
        double angleA = Math.toRadians(this.angleA);
        double test = this.cos = Math.cos(angleA);
        System.out.println(test + " TEST COS");
        return  test;
    }
    public double calcTanRec() {
        double angleA = Math.toRadians(this.angleA);
        double test = this.tang = Math.tan(angleA);
        System.out.println(test + " TEST TANG");
        return test;
    }


}
