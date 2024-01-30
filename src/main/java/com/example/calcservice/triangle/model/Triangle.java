package com.example.calcservice.triangle.model;
import com.example.calcservice.Figure;
import lombok.*;

@Data
@Builder
public class Triangle extends Figure {

    private final String keyMed = "med";
    private final String keyBess = "bess";
    private final String keyType = "type";

    private String triangleType;
    public Triangle(double a, double b, double c, double h) {
        super(a, b, c, h);
    }

    public Triangle(String triangleType) {
        this.triangleType = triangleType;
    };

    public double calcArea() {
        double s = (getA() + getB() + getC()) / 2;
        return Math.sqrt(s * (s -getA()) * (s - getB()) * (s - getC()));
    }
    public double calcPer() {
        return getA() + getB() + getC();
    }
    public double getTriangleMed() {
        return Math.sqrt(2 * getA()
                * getA() + 2 * getB()
                * getB() - getC()
                * getC()) * 0.5;
    }
    public double getTriangleBess() {
            return Math.sqrt(getA() * getB() *
                    (getA() + getB() + getC()) *
                    (getA() + getB() - getC())) /
                    (getA() + getB());
    }
    public String getType() {
        if (getA() == getB() && getB() == getC()) {
            return "Равносторонний";
        } else if (getA() == getB() || getB() == getC() || getA() == getC()) {
            return "Равнобедренный";
        } else {
            return "Разносторонний";
        }
    }
}
