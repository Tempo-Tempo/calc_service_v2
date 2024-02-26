package com.example.calcservice.triangle.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Data
@AllArgsConstructor
@Builder(builderMethodName = "recTangleBuilder")
public class RecTangle extends Triangle {

    private BigDecimal cos;
    private BigDecimal sin;
    private BigDecimal tang;
    private BigDecimal cosDegrees;
    private BigDecimal sinDegrees;
    private BigDecimal tangDegrees;

    public  RecTangle() {};
    public BigDecimal calcSinRec(BigDecimal angleA) {
        System.out.println(angleA + " sinRec");
        return this.sin = helper.sinus(angleA); }
    public BigDecimal calcSinRecDegrees() {
        return this.sinDegrees = this.sin.multiply(angleSum).divide(pi, 2, RoundingMode.HALF_UP);
    }
    public BigDecimal calcCosRec(BigDecimal angleA) { return this.cos = helper.cosine(angleA); }
    public BigDecimal calcCosRecDegrees() {
        return this.cosDegrees = this.cos.multiply(angleSum).divide(pi, 2, RoundingMode.HALF_UP);
    }
    public BigDecimal calcTanRec(BigDecimal angleA) {
        return this.tang = helper.cosine(angleA);
    }
    public BigDecimal calcTangRecDegrees() {
        return this.tangDegrees =  this.tang.multiply(angleSum).divide(pi, 2, RoundingMode.HALF_UP);
    }
    public void calcHypotenuseСathetus() {

    }
}
