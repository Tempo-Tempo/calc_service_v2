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
        calcAngles();
        if(a == 0 || b == 0 || c == 0) {
          calcWithAngle(angleA, angleB, angleC);
        } else {
            calcAnglesWithSides();
        }
        double s = (a + b + c) / 2;
        double test = this.area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.println(s + " s");
        System.out.println(s * (s - a) * (s - b) * (s - c));
        System.out.println(Math.sqrt(s * (s - a) * (s - b) * (s - c)));
        return test;
    }
    public void calcAngles() {
        if(angleB != 0 && angleC != 0) {
            this.angleA = 180 - (angleB + angleC);
        } else if (angleA != 0 && angleB != 0) {
           this.angleC = 180 - (angleA + angleB);
        } else if (angleA != 0 && angleC != 0) {
           this.angleB = 180 - (angleA + angleC);
        } else {

        }
    };

    public void calcWithAngle(double angleA, double angleB, double angleC) {
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
    }

    public void calcAnglesWithSides() {
        double angleA = Math.acos((b * b + c * c - a * a) / (2 * b * c));
        double angleB = Math.acos((a * a + c * c - b * b) / (2 * a * c));
        double angleC = Math.acos((a * a + b * b - c * c) / (2 * a * b));
        this.angleA = Math.toDegrees(angleA);
        System.out.println(this.angleA + " angleA");
        this.angleB = Math.toDegrees(angleB);
        System.out.println(this.angleB + " angleB");
        this.angleC = Math.toDegrees(angleC);
        System.out.println(this.angleC + " angleC");
    };
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
        if (a == b && b == c) {
            return this.typeTriangle = "Равносторонний";
        } else if (angleC == 90 && Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)
                || Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2) && angleA == 90
                || Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2) && angleB == 90) {
            return this.typeTriangle = "Прямоугольный";
        } else if (a == b || b == c || a == c) {
            return this.typeTriangle = "Равнобедренный";
        } else {
            return this.typeTriangle = "Разносторонний";
        }
    }
//     else if (Math.pow(array[0], 2) + Math.pow(array[1], 2) == Math.pow(array[2], 2)) {
//        return this.typeTriangle = "Прямоугольный";
//    } else if (Math.pow(array[0], 2) + Math.pow(array[1], 2) > Math.pow(array[2], 2)) {
//        return this.typeTriangle = "Остроугольный";
//    } else if (Math.pow(array[2], 2) > Math.pow(array[1], 2) + Math.pow(array[0], 2)) {
//        return this.typeTriangle = "Тупоугольный";
//    }
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
