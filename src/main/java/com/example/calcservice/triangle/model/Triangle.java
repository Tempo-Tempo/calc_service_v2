package com.example.calcservice.triangle.model;
import com.example.calcservice.Figure;
import lombok.*;

import java.util.Arrays;
import java.util.Map;

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

    public Triangle() {};
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    };

    @Override
    public double calcArea() {
        double s = (a + b + c) / 2;
        return this.area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
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
        System.out.println(angle);
        if (a == b && b == c) {
            return this.typeTriangle = "Равносторонний";
        } else if (a == b || b == c || a == c && angle != 90) {
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
