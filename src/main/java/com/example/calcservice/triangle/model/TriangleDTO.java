package com.example.calcservice.triangle.model;

import lombok.Data;

@Data
public class TriangleDTO {
    private double area;
    private double per;
    private double med;
    private double bess;
    private String typeTriangle;
    private double height;
    private double inCircle;
    private double outCircle;
    private double cos;
    private double sin;
    private double tang;
    private double cosDegrees;
    private double sinDegrees;
    private double tangDegrees;
    private String testErr;

    private double a;
    private double b;
    private double c;

    private double angleA;
    private double angleB;
    private double angleC;

    public TriangleDTO() {};
}
