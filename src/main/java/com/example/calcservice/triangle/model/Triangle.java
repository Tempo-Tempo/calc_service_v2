package com.example.calcservice.triangle.model;
import com.example.calcservice.Figure;
import lombok.*;


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
        }
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

    public void calcWithAngle(double angleA, double angleB, double angleC) {
        if (a == 0 && angleA != 0) {
            this.a = Math.sqrt((Math.pow(b, 2) + Math.pow(c, 2)) - (2 * b * c * Math.cos(angleA)));
            System.out.println(a + " this.a");
        } else if (b == 0 && angleB != 0) {
            this.b = Math.sqrt((Math.pow(a, 2) + Math.pow(c, 2)) - (2 * a * c * Math.cos(angleB)));
            System.out.println(b + " this.b");
        } else if (c == 0 && angleC != 0) {
            this.c = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)) - (2 * a * b * Math.cos(angleC)));
            System.out.println(c + " this.c");
        } else if (c == 0 && angleB != 0){
            double aSquared = Math.sqrt((Math.pow(b, 2) + Math.pow(c, 2) - 2 * b * c * Math.cos(angleB)));
            double cosAlpha = (Math.pow(b, 2) + Math.pow(c, 2) - aSquared) / (2 * b * c);
            double test = Math.acos(cosAlpha);
            System.out.println(Math.toDegrees(test) + " this.angleA");
        } else {

        }
        calcArea();
    }

    public void calcAnglesWithSides() {
        if  (this.angleA == 0) {
            double angleA = Math.acos((b * b + c * c - a * a) / (2 * b * c));
            this.angleA = Math.toRadians(Math.toDegrees(angleA));
        }
        if (this.angleB == 0) {
            double angleB = Math.acos((a * a + c * c - b * b) / (2 * a * c));
            this.angleB = Math.toRadians(Math.toDegrees(angleB));
        }
        if (this.angleC == 0) {
            double angleC = Math.acos((a * a + b * b - c * c) / (2 * a * b));
            this.angleC = Math.toRadians(Math.toDegrees(angleC));
        };
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
    public double calcHeight() {
            return this.height = (2 * this.area) / a;
    }
    public String getType() {
        if (a == b && b == c) {
            return this.typeTriangle = "Равносторонний";
        } else if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) && angleC == Math.toRadians(90)
                || Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2) && angleA == Math.toRadians(90)
                || Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2) && angleB == Math.toRadians(90)) {
            return this.typeTriangle = "Прямоугольный";
        } else if (a == b && angleA == angleB
                || b == c && angleB == angleC
                || a == c && angleA == angleC) {
            return this.typeTriangle = "Равнобедренный";
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
