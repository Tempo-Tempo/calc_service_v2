package com.example.calcservice.triangle.model;
import com.example.calcservice.Figure;
import lombok.*;

@Data
@Builder
public class Triangle extends Figure {

    private final String keyMed = "med";
    private final String keyBess = "bess";
    private final String keyType = "type";
    private final String getKeyInCircle = "inCircle";
    private final String getKeyOutCircle = "outCircle";

    private String triangleType;
    public Triangle( double a, double b, double c) {
        super(a, b, c);
    }

    public Triangle() {};

    public Triangle(String triangleType) {
        this.triangleType = triangleType;
    };
    @Override
    public double calcArea() {

        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    @Override
    public double calcPer() {
        return a + b + c;
    }
    public double calcMed() {
        return Math.sqrt(2 * a
                * a + 2 * b
                * b - c
                * c) * 0.5;
    }
    public double calcBess() {
            return Math.sqrt(a * b *
                    (a + b + c) *
                    (a + b - c)) /
                    (a + b);
    }
    public String getType() {
        if (a == b && b == c) {
            return "Равносторонний";
        } else if (a == b || b == c || a == c) {
            return "Равнобедренный";
        } else {
            return "Разносторонний";
        }
    }

    public double inCircleArea() {
       double r = calcArea() / (calcPer() / 2);
       return pi * Math.pow(r, 2);
    };
    public double outCircleArea() {
        double p = calcPer() / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        double r = a * b * c / (4 * s);
        return pi * Math.pow(r, 2);
    };
}
