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
        calcWithAngleSin();

        if(a == 0 || b == 0 || c == 0) {
          calcWithAngle(angleA, angleB, angleC);

        }
        calcAnglesWithSides();

        // ТАКОГО ТРЕУГОЛЬНИКА НЕ СУЩЕСТВУЕТ! Проверка по  формуле синусов
//                if(Math.sin(this.angleC) * a / c > 1) {
//                    System.out.println("СРАБОТАЛА ПРОВЕРКА 1");
//                } else if (Math.sin(this.angleC) * b / c > 1) {
//                    System.out.println("СРАБОТАЛА ПРОВЕРКА 2");
//                } else if(Math.sin(this.angleB) * a / b > 1)  {
//                    System.out.println("СРАБОТАЛА ПРОВЕРКА 3");
//                } else if (Math.sin(this.angleB) * c / b > 1) {
//                    System.out.println("СРАБОТАЛА ПРОВЕРКА 4");
//                } else if(Math.sin(this.angleA) * c / a > 1) {
//                    System.out.println("СРАБОТАЛА ПРОВЕРКА 5");
//                } else if (Math.sin(this.angleA) * b / a > 1) {
//                    System.out.println("СРАБОТАЛА ПРОВЕРКА 6");
//                }
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
        } else {

        }
        calcArea();
    }

    public void calcWithAngleSin() {
         if(a != 0 && b != 0 && angleA != 0 || a != 0 && c != 0 && angleA != 0) {
            double sinB =  Math.sin(this.angleA) * b / a;
            double sinC =  Math.sin(this.angleA) * c / a;
            if (sinB < -1.0 || sinB > 1.0 || sinC < -1.0 || sinC > 1.0 ) {
                System.out.println("Такого треугольника не существует.");
                return;
            } else {
                this.angleB = Math.asin(sinB);
                this.angleC = Math.asin(sinC);
                System.out.println(Math.round(Math.toDegrees(this.angleB)) + " asinB");
                System.out.println(Math.round(Math.toDegrees(this.angleC)) + " asinC");
                System.out.println(Math.round(Math.toDegrees(this.angleA)) + " sinA");
                calcAngles();
            }
         }
        if(a != 0 && c != 0 && angleC != 0 || b != 0 && c != 0 && angleC != 0) {
            double sinA =  Math.sin(this.angleC) * a / c;
            double sinB =  Math.sin(this.angleC) * b / c;
            if (sinB < -1.0 || sinB > 1.0 || sinA < -1.0 || sinA > 1.0 ) {
                System.out.println("Такого треугольника не существует.");
                return;
            } else {
                this.angleA = Math.asin(sinA);
                this.angleB = Math.asin(sinB);
                System.out.println(Math.round(Math.toDegrees(this.angleA)) + " asinA");
                System.out.println(Math.round(Math.toDegrees(this.angleB)) + " asinB");
                System.out.println(Math.round(Math.toDegrees(this.angleC)) + " sinC");
                calcAngles();
            }
        }
        if(b != 0 && c != 0 && angleB != 0 || b != 0 && a != 0 && angleB != 0) {
            double sinC =  Math.sin(this.angleB) * c / b;
            double sinA =  Math.sin(this.angleB) * a / b;
            if (sinC < -1.0 || sinC > 1.0 || sinA < -1.0 || sinA > 1.0 ) {
                System.out.println("Такого треугольника не существует.");
                return;
            } else {
                this.angleC = Math.asin(sinC);
                this.angleA = Math.asin(sinA);
                System.out.println(Math.round(Math.toDegrees(this.angleC)) + " sinC");
                System.out.println(Math.round(Math.toDegrees(this.angleA)) + " sinA");
                System.out.println(Math.round(Math.toDegrees(this.angleB)) + " sinB");
                calcAngles();
            }
        }
        System.out.println(Math.round(Math.toDegrees(angleA)) + " angleA");
        System.out.println(Math.round(Math.toDegrees(angleB)) + " angleB");
        System.out.println(Math.round(Math.toDegrees(angleC)) + " angleC");
        System.out.println(a + " сторона a");
        System.out.println(b + " сторона b");
        System.out.println(c + " сторона c");
    }

    public void calcAnglesWithSides() {
        if (this.angleA == 0) {
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
        if (Math.round(a) == Math.round(b) && Math.round(b) == Math.round(c)
                && Math.round(angleA) == Math.round(angleB) && Math.round(angleB) == Math.round(angleC)) {
            return this.typeTriangle = "Равносторонний";
        } else if (Math.round(Math.toDegrees(angleA))== 90
                || Math.round(Math.toDegrees(angleB)) == 90
                || Math.round(Math.toDegrees(angleC)) == 90) {
            return this.typeTriangle = "Прямоугольный";
        } else if (a == b && Math.round(angleA) == Math.round(angleB)
                || b == c && Math.round(angleB) == Math.round(angleC)
                || a == c && Math.round(angleA) == Math.round(angleC)) {
            return this.typeTriangle = "Равнобедренный";
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
