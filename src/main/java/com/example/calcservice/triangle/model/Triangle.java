package com.example.calcservice.triangle.model;
import com.example.calcservice.Figure;
import lombok.*;

import java.util.Arrays;

@Data
@Builder
@AllArgsConstructor
public class Triangle extends Figure {
    private double area;
    private double per;
    private double med;
    private double bess;
    private double cos;
    private double sin;
    private double tang;
    private double inCircle;
    private double outCircle;
    private String typeTriangle;

    protected double angleA;
    protected double angleB;
    protected double angleC;

    public Triangle() {};
    public Triangle(double a, double b, double c, double angleA, double angleB, double angleC) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.angleA = angleA;
        this.angleB = angleB;
        this.angleC = angleC;
    };

    @Override
    public double calcArea() {
        if(a == 0 || b == 0 || c == 0) {
          return calcWithAngle(angleA, angleB, angleC);
        }
        double s = (a + b + c) / 2;
        return this.area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    public double calcWithAngle(double angleA, double angleB, double angleC) {
        System.out.println("work");
        if (a == 0 && angleA != 0) {
            this.a = Math.sqrt((Math.pow(b, 2) + Math.pow(c, 2)) - (2 * b * c * Math.cos(angleA)));
        } else if (b == 0 && angleB != 0) {
            this.b = Math.sqrt((Math.pow(a, 2) + Math.pow(c, 2)) - (2 * a * c * Math.cos(angleB)));
        } else if (c == 0 && angleC != 0) {
            this.c = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)) - (2 * a * b * Math.cos(angleC)));
        } else {
          System.out.println(this.c + "this.c");
        }
        calcArea();
        System.out.println(this.c + "this.c");
        return this.area;
    }
    @Override
    public double calcPer() {
        return this.per = a + b + c;
    }
    public double calcMed() {
        return this.med = Math.sqrt(2 * a
                * a + 2 * b
                * b - c
                * c) * 0.5;
    }
    public double calcBess() {
            return this.bess = Math.sqrt(a * b *
                    (a + b + c) *
                    (a + b - c)) /
                    (a + b);
    }
    public String getType() {
        double[] array = new double[]{a, b, c};
        Arrays.sort(array);
          double angle = Math.toDegrees(Math.atan2(array[0], array[1]));
//        double angle2 = Math.acos((Math.pow(array[0], 2) + Math.pow(array[1], 2)) - Math.pow(array[2], 2))
//                / (2 * array[0] * array[1]);
       System.out.println(angle + "test1");
//        System.out.println(angle2 + "test2");
        if (a == b && b == c) {
            return this.typeTriangle = "Равносторонний";
        } else if (a == b || b == c || a == c) {
            return this.typeTriangle = "Равнобедренный";
        } else if (Math.pow(array[0], 2) + Math.pow(array[1], 2) == Math.pow(array[2], 2)) {
            return this.typeTriangle = "Прямоугольный";
        } else if (Math.pow(array[0], 2) + Math.pow(array[1], 2) > Math.pow(array[2], 2)) {
            return this.typeTriangle = "Остроугольный";
        } else if (Math.pow(array[2], 2) > Math.pow(array[1], 2) + Math.pow(array[0], 2)) {
            return this.typeTriangle = "Тупоугольный";
        } else {
            return this.typeTriangle = "Разносторонний";
        }
    }
    public double inCircleArea() {
       double r = calcArea() / (calcPer() / 2);
       return this.inCircle = pi * Math.pow(r, 2);
    };
    public double outCircleArea() {
        double p = calcPer() / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        double r = a * b * c / (4 * s);
        return this.outCircle = pi * Math.pow(r, 2);
    };
}
