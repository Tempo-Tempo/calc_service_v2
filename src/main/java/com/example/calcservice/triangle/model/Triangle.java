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

    DecimalFormat format = new DecimalFormat("#.#");

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
        System.out.println(Math.round(Math.toDegrees(this.angleA)) + " sinA");
        System.out.println(Math.round(Math.toDegrees(this.angleB)) + " asinB");
        System.out.println(Math.round(Math.toDegrees(this.angleC)) + " asinC");
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
            System.out.println(a + " this.a");
        } else if (b == 0 && angleB != 0) {
            this.b = Math.sqrt((Math.pow(a, 2) + Math.pow(c, 2)) - (2 * a * c * Math.cos(angleB)));
            System.out.println(b + " this.b");
        } else if (c == 0 && angleC != 0 ) {
            this.c = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)) - (2 * a * b * Math.cos(angleC)));
            System.out.println(c + " this.c");
        } else {

        }
    }
    public void calcWithAngleSin() {
         if(c == 0 && angleC == 0 && angleB == 0 && angleA != 0
                 || a != 0 && b != 0 && c != 0 && angleB == 0) {
            double sinB =  Math.sin(this.angleA) * b / a;
             System.out.println(angleA + " УСЛОВИЕ 1");
            if (sinB < -1.0 || sinB > 1.0 ) {
                this.testErr = "Такого треугольника не существует.";
                return;
            } else {
                calcAngles();
                this.angleB = Math.asin(sinB);
                return;
            }
         }
        if(c == 0 && angleC == 0 && angleB != 0
                || a != 0 && b != 0 && c != 0 && angleC == 0) {
            double sinC =  Math.sin(this.angleB) * a / b;
            System.out.println(angleA + " УСЛОВИЕ 2");
            if (sinC < -1.0 || sinC > 1.0 ) {
                this.testErr = "Такого треугольника не существует.";
                return;
            } else {
                this.angleC = Math.asin(sinC);
                System.out.println(Math.toDegrees(angleB) + " alo");
                System.out.println(Math.toDegrees(angleA) + " alo");
            }
        }
        if(b == 0 && angleB == 0 && angleA != 0
                || a != 0 && b != 0 && c != 0 && angleB == 0) {
            double sinB = Math.sin(this.angleA) * c / a;
            System.out.println(angleA + " УСЛОВИЕ 3");
            if (sinB < -1.0 || sinB > 1.0 ) {
                this.testErr = "Такого треугольника не существует.";
                return;
            } else {
                this.angleB = Math.asin(sinB);
            }
        }
        if(b == 0 && angleB == 0 && angleC != 0
                || a != 0 && b != 0 && c != 0 && angleB == 0) {
            double sinB = Math.sin(this.angleC) * a / c;
            System.out.println(angleA + " УСЛОВИЕ 4");
            if (sinB < -1.0 || sinB > 1.0 ) {
                this.testErr = "Такого треугольника не существует.";
                return;
            } else {
                this.angleB = Math.asin(sinB);
            }
        }
        if(a == 0 && angleA == 0 && angleB != 0
                || a != 0 && b != 0 && c != 0 && angleC == 0) {
            double sinC =  Math.sin(this.angleB) * c / b;
            System.out.println(angleA + " УСЛОВИЕ 5");
            System.out.println(sinC + " alo");
            if (sinC < -1.0 || sinC > 1.0 ) {
                this.testErr = "Такого треугольника не существует.";
                return;
            } else {
                this.angleC = Math.asin(sinC);
            }

        }
        if(a == 0 && angleA == 0 && angleC != 0
                || a != 0 && b != 0 && c != 0 && angleB == 0) {
            double sinB =  Math.sin(this.angleC) * b / c;
            System.out.println(angleA + " УСЛОВИЕ 6");
            if (sinB < -1.0 || sinB > 1.0 ) {
                this.testErr = "Такого треугольника не существует.";
                return;
            } else {
                this.angleB = Math.asin(sinB);
            }
        }
    }

    public void calcAnglesWithSides() {
        if (a != 0 && b != 0 && c != 0 && angleA == 0 && angleB == 0 && angleC == 0)  {
            this.angleA = Math.acos((b * b + c * c - a * a) / (2 * b * c));
            this.angleB = Math.acos((a * a + c * c - b * b) / (2 * a * c));
            this.angleC = Math.acos((a * a + b * b - c * c) / (2 * a * b));
            calcWithAngleSin();
        } else {
            calcWithAngleSin();
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
            return this.height = (2 * this.area) / a;
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

//    Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) && angleC == Math.toRadians(90)
//            || Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2) && angleA == Math.toRadians(90)
//            || Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2) && angleB == Math.toRadians(90)
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







// if(a != 0 && b != 0 && angleA != 0 || a != 0 && c != 0 && angleA != 0) {
//double sinB =  Math.sin(this.angleA) * b / a;
//double sinC =  Math.sin(this.angleA) * c / a;
//            if (sinB < -1.0 || sinB > 1.0 || sinC < -1.0 || sinC > 1.0 ) {
//        System.out.println("Такого треугольника не существует.");
//                return;
//                        } else {
//                        this.angleB = Math.asin(sinB);
//                this.angleC = Math.asin(sinC);
////                System.out.println(Math.round(Math.toDegrees(this.angleB)) + " asinB");
////                System.out.println(Math.round(Math.toDegrees(this.angleC)) + " asinC");
////                System.out.println(Math.round(Math.toDegrees(this.angleA)) + " sinA");
//calcAngles();
//            }
//                    }
//                    if(a != 0 && c != 0 && angleC != 0 || b != 0 && c != 0 && angleC != 0) {
//double sinA =  Math.sin(this.angleC) * a / c;
//double sinB =  Math.sin(this.angleC) * b / c;
//            if (sinB < -1.0 || sinB > 1.0 || sinA < -1.0 || sinA > 1.0 ) {
//        System.out.println("Такого треугольника не существует.");
//                return;
//                        } else {
//                        this.angleA = Math.asin(sinA);
//                this.angleB = Math.asin(sinB);
//                System.out.println(Math.round(Math.toDegrees(this.angleA)) + " asinA");
//        System.out.println(Math.round(Math.toDegrees(this.angleB)) + " asinB");
//        System.out.println(Math.round(Math.toDegrees(this.angleC)) + " sinC");
//calcAngles();
//            }
//                    }
//                    if(b != 0 && c != 0 && angleB != 0 || b != 0 && a != 0 && angleB != 0) {
//double sinC =  Math.sin(this.angleB) * c / b;
//double sinA =  Math.sin(this.angleB) * a / b;
//            if (sinC < -1.0 || sinC > 1.0 || sinA < -1.0 || sinA > 1.0 ) {
//        System.out.println("Такого треугольника не существует.");
//                return;
//                        } else {
//                        this.angleC = Math.asin(sinC);
//                this.angleA = Math.asin(sinA);
//                System.out.println(Math.round(Math.toDegrees(this.angleC)) + " sinC");
//        System.out.println(Math.round(Math.toDegrees(this.angleA)) + " sinA");
//        System.out.println(Math.round(Math.toDegrees(this.angleB)) + " sinB");
//calcAngles();
//            }
//                    }