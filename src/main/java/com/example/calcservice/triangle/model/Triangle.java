package com.example.calcservice.triangle.model;
import com.example.calcservice.Figure;
import com.example.calcservice.triangle.helpers.BigDecimalMath;
import lombok.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


@Data
@Builder
@AllArgsConstructor
public class Triangle extends Figure {
    private BigDecimal area;
    private BigDecimal two = new BigDecimal("2");
    private BigDecimal zero = new BigDecimal("0");
    BigDecimal angleSum = new BigDecimal("180");
    private BigDecimal per;
    private BigDecimal med;
    private BigDecimal bess;
    private BigDecimal height;
    private BigDecimal inCircle;
    private BigDecimal outCircle;
    private String typeTriangle;
    private String testErr;

    protected BigDecimal angleA;
    protected BigDecimal angleB;
    protected BigDecimal angleC;

    BigDecimalMath helper = new BigDecimalMath();

    public Triangle() {};
    public Triangle(BigDecimal a, BigDecimal b, BigDecimal c,
                    BigDecimal angleA, BigDecimal angleB, BigDecimal angleC) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.angleA = angleA;
        this.angleB = angleB;
        this.angleC = angleC;
    };

    @Override
    public BigDecimal calcArea() {
        calcAngles();
        calcAnglesWithSides();
        BigDecimal s = (a.add(b).add(c)).divide(two, 2 , RoundingMode.HALF_UP);
        BigDecimal area = s.multiply(s.subtract(a))
                             .multiply(s.subtract(b))
                             .multiply(s.subtract(c));
        return this.area = area.sqrt(MathContext.DECIMAL128);
    }
    public void calcAngles() {
        BigDecimal angleSumToRadians = angleSum.multiply(pi).divide(angleSum, 8, RoundingMode.HALF_UP);
        if(angleB.compareTo(zero) != 0 && angleC.compareTo(zero) != 0 ) {
           this.angleA = angleSumToRadians.subtract(angleB.add(angleC));
        } else if (angleB.compareTo(zero) != 0 && angleA.compareTo(zero) != 0) {
           this.angleC = angleSumToRadians.subtract(angleB.add(angleA));
        } else if (angleA.compareTo(zero) != 0 && angleC.compareTo(zero) != 0) {
            this.angleB = angleSumToRadians.subtract(angleA.add(angleC));
        } else {
            return;
        }
    };

    public void calcWithAngleCos() {
        if (b.compareTo(zero) != 0 && c.compareTo(zero) != 0 && angleA.compareTo(zero) != 0) {
            BigDecimal bSquared = b.multiply(b);
            BigDecimal cSquared = c.multiply(c);
            BigDecimal cosA = helper.cosine(angleA);
            BigDecimal result = bSquared.add(cSquared).subtract(two.multiply(b).multiply(c).multiply(cosA));
            this.a = result.sqrt(MathContext.DECIMAL128).setScale(0, RoundingMode.HALF_UP);
        } else if (a.compareTo(zero) != 0 && c.compareTo(zero) != 0 && angleB.compareTo(zero) != 0) {
            BigDecimal aSquared = a.multiply(a);
            BigDecimal cSquared = c.multiply(c);
            BigDecimal cosB = helper.cosine(angleB);
            BigDecimal result = aSquared.add(cSquared).subtract(two.multiply(a).multiply(c).multiply(cosB));
            this.b = result.sqrt(MathContext.DECIMAL128).setScale(0, RoundingMode.HALF_UP);
        } else if (a.compareTo(zero) != 0 && b.compareTo(zero) != 0 && angleC.compareTo(zero) != 0 ) {
            BigDecimal aSquared = a.multiply(a);
            BigDecimal bSquared = b.multiply(b);
            BigDecimal cosC = helper.cosine(angleC);
            BigDecimal result = aSquared.add(bSquared).subtract(two.multiply(a).multiply(b).multiply(cosC));
            this.c = result.sqrt(MathContext.DECIMAL128).setScale(0, RoundingMode.HALF_UP);
        } else {
            calcWithAngleSin();
        }
    }
    public void calcWithAngleSin() {
        BigDecimal minusOne = new BigDecimal("-1.0");
        BigDecimal one = new BigDecimal("1.0");
         if(angleB.compareTo(zero) == 0 && angleA.compareTo(zero) != 0 && a.compareTo(zero) != 0 && b.compareTo(zero) != 0) {
            BigDecimal sinB = helper.sinus(angleA).multiply(b).divide(a, 2, RoundingMode.HALF_UP);
            if (sinB.compareTo(minusOne) < 0 || sinB.compareTo(one) > 0) {
                this.testErr = "Такого треугольника не существует.";
            } else {
                this.angleB = helper.arcSinus(sinB);
            }
         } else if(angleA.compareTo(zero) == 0 && angleB.compareTo(zero) != 0 && a.compareTo(zero) != 0 && b.compareTo(zero) != 0) {
             BigDecimal sinA = helper.sinus(angleB).multiply(a).divide(b, 2, RoundingMode.HALF_UP);
             if (sinA.compareTo(minusOne) < 0 || sinA.compareTo(one) > 0) {
                 this.testErr = "Такого треугольника не существует.";
             } else {
                 this.angleA = helper.arcSinus(sinA);
             }
         } else if(angleC.compareTo(zero) == 0 && angleA.compareTo(zero) != 0 && c.compareTo(zero) != 0 && a.compareTo(zero) != 0) {
             BigDecimal sinC = helper.sinus(angleA).multiply(c).divide(a, 2, RoundingMode.HALF_UP);
             if (sinC.compareTo(minusOne) < 0 || sinC.compareTo(one) > 0) {
                 this.testErr = "Такого треугольника не существует.";
                 return;
             } else {
                 this.angleC = helper.arcSinus(sinC);
             }
         } else if(angleA.compareTo(zero) == 0 && angleC.compareTo(zero) != 0 && a.compareTo(zero) != 0 && c.compareTo(zero) != 0) {
             BigDecimal sinA = helper.sinus(angleC).multiply(a).divide(c, 2, RoundingMode.HALF_UP);
             if (sinA.compareTo(minusOne) < 0 || sinA.compareTo(one) > 0) {
                 this.testErr = "Такого треугольника не существует.";
             } else {
                 this.angleA = helper.arcSinus(sinA);
             }
         } else if(angleC.compareTo(zero) == 0 && angleB.compareTo(zero) != 0 && c.compareTo(zero) != 0 && b.compareTo(zero) != 0) {
             BigDecimal sinC = helper.sinus(angleB).multiply(c).divide(b, 2, RoundingMode.HALF_UP);
             if (sinC.compareTo(minusOne) < 0 || sinC.compareTo(one) > 0) {
                 this.testErr = "Такого треугольника не существует.";
             } else {
                 this.angleC = helper.arcSinus(sinC);
             }
         } else if(angleB.compareTo(zero) == 0 && angleC.compareTo(zero) != 0 && b.compareTo(zero) != 0 && c.compareTo(zero) != 0) {
             BigDecimal sinB = helper.sinus(angleC).multiply(b).divide(c, 2, RoundingMode.HALF_UP);
             if (sinB.compareTo(minusOne) < 0 || sinB.compareTo(one) > 0) {
                 this.testErr = "Такого треугольника не существует.";
             } else {
                 this.angleB = helper.arcSinus(sinB);
             }
         } else if (angleC.compareTo(zero) != 0 && angleA.compareTo(zero) != 0 && angleB.compareTo(zero) != 0) {
             calcWithOneSideSin();
         }
        calcArea();
    }

    public void calcWithOneSideSin() {
        if(a.compareTo(zero) != 0) {
            this.b = a.multiply(helper.sinus(angleB).divide(helper.sinus(angleA), 2, RoundingMode.HALF_UP));
            this.c = a.multiply(helper.sinus(angleC).divide(helper.sinus(angleA), 2, RoundingMode.HALF_UP));
        } else if (b.compareTo(zero) != 0) {
            this.a = b.multiply(helper.sinus(angleA).divide(helper.sinus(angleB), 2, RoundingMode.HALF_UP));
            this.c = b.multiply(helper.sinus(angleC).divide(helper.sinus(angleB), 2, RoundingMode.HALF_UP));
        } else if(c.compareTo(zero) != 0) {
            this.a = c.multiply(helper.sinus(angleA).divide(helper.sinus(angleC), 2, RoundingMode.HALF_UP));
            this.b = c.multiply(helper.sinus(angleB).divide(helper.sinus(angleC), 2, RoundingMode.HALF_UP));
        }
    }
    public void calcAnglesWithSides() {
        if (a.compareTo(zero) != 0 && b.compareTo(zero) != 0 && c.compareTo(zero) != 0)  {
            BigDecimal aSquared = a.multiply(a);
            BigDecimal bSquared = b.multiply(b);
            BigDecimal cSquared = c.multiply(c);
            BigDecimal resultA = bSquared.add(cSquared).subtract(aSquared).divide(two.multiply(b).multiply(c),5 , RoundingMode.HALF_UP);
            BigDecimal resultB = aSquared.add(cSquared).subtract(bSquared).divide(two.multiply(a).multiply(c),5 , RoundingMode.HALF_UP);
            BigDecimal resultC = aSquared.add(bSquared).subtract(cSquared).divide(two.multiply(a).multiply(b),5 , RoundingMode.HALF_UP);
            this.angleA = helper.arcCosine(resultA);
            this.angleB = helper.arcCosine(resultB);
            this.angleC = helper.arcCosine(resultC);
            formatCeil();
        } else {
            calcWithAngleCos();
        }
    };
    public void formatCeil() {
        this.angleA = angleA.multiply(angleSum).divide(pi, 0, RoundingMode.HALF_UP);
        this.angleB = angleB.multiply(angleSum).divide(pi, 0, RoundingMode.HALF_UP);
        this.angleC = angleC.multiply(angleSum).divide(pi, 0, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal calcPer() {
        return this.per = a.add(b).add(c);
    }
    public BigDecimal calcMed() {
        BigDecimal aSquared = a.multiply(a);
        BigDecimal bSquared = b.multiply(b);
        BigDecimal cSquared = c.multiply(c);
        BigDecimal half = new BigDecimal("0.5");
        BigDecimal result = two.multiply(aSquared).add(two.multiply(bSquared).subtract(cSquared));
        return this.med = result.sqrt(MathContext.DECIMAL128).multiply(half);
    }
    public BigDecimal calcBess() {
        BigDecimal abc = a.add(b).add(c);
        BigDecimal ab_c = a.add(b).subtract(c);
        BigDecimal ab = a.add(b);
        BigDecimal result = a.multiply(b).multiply(abc).multiply(ab_c);
        return this.bess = result.sqrt(MathContext.DECIMAL128).divide(ab, 2, RoundingMode.HALF_UP);
    }
    public BigDecimal calcHeight() {
            return this.height = two.multiply(calcArea()).divide(b,2, RoundingMode.HALF_UP);
    }
    public String getType() {
        BigDecimal aSquared = a.multiply(a);
        BigDecimal bSquared = b.multiply(b);
        BigDecimal cSquared = c.multiply(c);
        BigDecimal angle90 = new BigDecimal("90");
        if (a.compareTo(b) == 0
                && b.compareTo(c) == 0
                && angleA.compareTo(angleB) == 0
                && angleB.compareTo(angleC) == 0) {
            return this.typeTriangle = "Равносторонний";
        } else if (aSquared.add(bSquared).compareTo(cSquared) == 0 && angleC.compareTo(angle90) == 0
                || bSquared.add(cSquared).compareTo(aSquared) == 0 && angleA.compareTo(angle90) == 0
                || aSquared.add(cSquared).compareTo(bSquared) == 0 && angleB.compareTo(angle90) == 0) {
            return this.typeTriangle = "Прямоугольный";
        } else if (a.compareTo(b) == 0 && angleA.compareTo(angleB) == 0
                || b.compareTo(c) == 0 && angleB.compareTo(angleC) == 0
                || c.compareTo(a) == 0 && angleC.compareTo(angleA) == 0) {
            return this.typeTriangle = "Равнобедренный";
        } else if (aSquared.add(bSquared).compareTo(cSquared) < 0
                || bSquared.add(cSquared).compareTo(aSquared) < 0
                || aSquared.add(cSquared).compareTo(bSquared) < 0) {
            return this.typeTriangle = "Тупоугольный";
        } else if (aSquared.add(bSquared).compareTo(cSquared) > 0
                || bSquared.add(cSquared).compareTo(aSquared) > 0
                || aSquared.add(cSquared).compareTo(bSquared) > 0) {
            return this.typeTriangle = "Остроугольный";
        } else {
            return this.typeTriangle = "Разносторонний";
        }
    }
    public BigDecimal inCircleArea() {
        BigDecimal halfPer = calcPer().divide(two, 2, RoundingMode.HALF_UP);
        BigDecimal r = calcArea().divide(halfPer, 2, RoundingMode.HALF_UP);
        BigDecimal rSquared = r.multiply(r);
       return this.inCircle = pi.multiply(rSquared);
    };
    public BigDecimal outCircleArea() {
        BigDecimal p = calcPer().divide(two, 2, RoundingMode.HALF_UP);
        BigDecimal s = p.multiply(p.subtract(a).multiply(p.subtract(b)).multiply(p.subtract(c))).sqrt(MathContext.DECIMAL128);
        BigDecimal four = new BigDecimal("4");
        BigDecimal r = a.multiply(b).multiply(c).divide(four.multiply(s), 2, RoundingMode.HALF_UP);
        BigDecimal rSquare = r.multiply(r);
        return this.outCircle = pi.multiply(rSquare);
    };
}