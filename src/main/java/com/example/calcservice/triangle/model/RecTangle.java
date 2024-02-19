package com.example.calcservice.triangle.model;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RecTangle extends Triangle {

    private double cos;
    private double sin;
    private double tang;
    private double cosDegrees;
    private double sinDegrees;
    private double tangDegrees;

    public  RecTangle() {};
    public double calcSinRec(double angleA) {
        return  this.sin = Math.sin(Math.toRadians(angleA));
    }
    public double calcSinRecDegrees() {
        return this.sinDegrees = Math.toDegrees(this.sin);
    }
    public double calcCosRec(double angleA) {
        return  this.cos = Math.cos(Math.toRadians(angleA));
    }
    public double calcCosRecDegrees() {
        return  this.cosDegrees = Math.toDegrees(this.cos);
    }
    public double calcTanRec(double angleA) {
        return this.tang = Math.tan(Math.toRadians(angleA));
    }
    public double calcTangRecDegrees() {
        return this.tangDegrees = Math.toDegrees(this.tang);
    }


}
