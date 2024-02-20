package com.example.calcservice.triangle.model;
import com.example.calcservice.Figure;
import lombok.*;

import java.text.DecimalFormat;


@Data
@Builder
@AllArgsConstructor
public class Triangle extends Figure {
    private double area;
    private double per;
    private double med;
    private double bess;
    private double height;
    private double inCircle;
    private double outCircle;
    private String typeTriangle;
    private String testErr;

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
        calcAnglesWithSides();
        double s = (a + b + c) / 2;
        return this.area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    public void calcAngles() {
        if(angleB != 0 && angleC != 0) {
           this.angleA = Math.toRadians(180) - (angleB + angleC);
        } else if (angleA != 0 && angleB != 0) {
           this.angleC = Math.toRadians(180) - (angleA + angleB);
        } else if (angleA != 0 && angleC != 0) {
            this.angleB = Math.toRadians(180) - (angleA + angleC);
        } else {
            return;
        }
    };

    public void calcWithAngleCos() {
        if (a == 0 && angleA != 0) {
            this.a = Math.sqrt((Math.pow(b, 2) + Math.pow(c, 2)) - (2 * b * c * Math.cos(angleA)));
        } else if (b == 0 && angleB != 0) {
            this.b = Math.sqrt((Math.pow(a, 2) + Math.pow(c, 2)) - (2 * a * c * Math.cos(angleB)));
        } else if (c == 0 && angleC != 0 ) {
            this.c = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)) - (2 * a * b * Math.cos(angleC)));
        } else {
            calcWithAngleSin();
        }
    }
    public void calcWithAngleSin() {
         if(angleB == 0 && angleA != 0 && b != 0 && a != 0) {
            double sinB = Math.sin(this.angleA) * b / a;    
            if (sinB < -1.0 || sinB > 1.0) {
                this.testErr = "Такого треугольника не существует.";
            } else {
                this.angleB = Math.asin(sinB);;
            }
         } else if(angleC == 0 && angleB != 0 && a != 0 && b != 0) {
            double sinC =  Math.sin(this.angleB) * a / b;
            if (sinC < -1.0 || sinC > 1.0 ) {
                this.testErr = "Такого треугольника не существует.";
            } else {
                this.angleC = Math.asin(sinC);
            }
        } else if(angleB == 0 && angleA != 0 && c != 0 && a != 0) {
            double sinB = Math.sin(this.angleA) * c / a;
            if (sinB < -1.0 || sinB > 1.0 ) {
                this.testErr = "Такого треугольника не существует.";
            } else {
                this.angleB = Math.asin(sinB);
            }
        } else if(angleB == 0 && angleC != 0 && a != 0 && c != 0) {
            double sinB = Math.sin(this.angleC) * a / c;
            if (sinB < -1.0 || sinB > 1.0 ) {
                this.testErr = "Такого треугольника не существует.";
                return;
            } else {
                this.angleB = Math.asin(sinB);
            }
        } else if(angleC == 0 && angleB != 0 && c != 0 && b != 0) {
            double sinC =  Math.sin(this.angleB) * c / b;
            if (sinC < -1.0 || sinC > 1.0 ) {
                this.testErr = "Такого треугольника не существует.";
            } else {
                this.angleC = Math.asin(sinC);
            }
        } else if(angleB == 0 && angleC != 0 && b != 0 && c != 0) {
            double sinB =  Math.sin(this.angleC) * b / c;
            if (sinB < -1.0 || sinB > 1.0 ) {
                this.testErr = "Такого треугольника не существует.";
            } else {
                this.angleB = Math.asin(sinB);
            }
        }
    }
    public void calcAnglesWithSides() {
        if (a != 0 && b != 0 && c != 0)  {
            this.angleA = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * b * c));
            this.angleB = Math.acos((Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / (2 * a * c));
            this.angleC = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
        } else {
            calcWithAngleCos();
            calcAngles();
        }
    };

    public void formatCeil() {
        this.a = Math.round(a);
        this.b = Math.round(b);
        this.c = Math.round(c);
        this.angleA = Math.round(Math.toDegrees(this.angleA));
        this.angleB = Math.round(Math.toDegrees(this.angleB));
        this.angleC = Math.round(Math.toDegrees(this.angleC));
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
    public double calcHeight() {
            return this.height = (2 * this.area) / b;
    }
    public String getType() {
        formatCeil();
        if (a == b && b == c && angleA == angleB && angleB == angleC) {
            return this.typeTriangle = "Равносторонний";
        } else if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) && angleC == 90
                || Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2) && angleA == 90
                || Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2) && angleB == 90) {
            return this.typeTriangle = "Прямоугольный";
        } else if (a == b && angleA == angleB
                || b == c && angleB == angleC
                || c == a && angleC == angleA) {
            return this.typeTriangle = "Равнобедренный";
        } else if (Math.pow(a, 2) + Math.pow(b, 2) < Math.pow(c, 2)
                || Math.pow(b, 2) + Math.pow(c, 2) < Math.pow(a, 2)
                || Math.pow(a, 2) + Math.pow(c, 2) < Math.pow(b, 2)) {
            return this.typeTriangle = "Тупоугольный";
        } else if (Math.pow(a, 2) + Math.pow(b, 2) > Math.pow(c, 2)
                || Math.pow(b, 2) + Math.pow(c, 2) > Math.pow(a, 2)
                || Math.pow(a, 2) + Math.pow(c, 2) > Math.pow(b, 2) ) {
            return this.typeTriangle = "Остроугольный";
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