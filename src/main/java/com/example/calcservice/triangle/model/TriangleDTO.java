package com.example.calcservice.triangle.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TriangleDTO {
    private BigDecimal area;
    private BigDecimal per;
    private BigDecimal med;
    private BigDecimal bess;
    private String typeTriangle;
    private BigDecimal height;
    private BigDecimal inCircle;
    private BigDecimal outCircle;
    private BigDecimal cos;
    private BigDecimal sin;
    private BigDecimal tang;
    private BigDecimal cosDegrees;
    private BigDecimal sinDegrees;
    private BigDecimal tangDegrees;
    private String testErr;

    private BigDecimal a;
    private BigDecimal b;
    private BigDecimal c;

    private BigDecimal angleA;
    private BigDecimal angleB;
    private BigDecimal angleC;

    public TriangleDTO() {};
}
