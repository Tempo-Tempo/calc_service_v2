package com.example.calcservice.triangle.service.impl;
import com.example.calcservice.config.MapperConfig;
import com.example.calcservice.triangle.model.RecTangle;
import com.example.calcservice.triangle.model.Triangle;
import com.example.calcservice.triangle.model.TriangleDTO;
import com.example.calcservice.triangle.service.TriangleInterface;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class TriangleService implements TriangleInterface {
    MapperConfig mapper = new MapperConfig();
    @Override
    public TriangleDTO resultCalcTriangle(BigDecimal a, BigDecimal b, BigDecimal c,
                                          BigDecimal angleA, BigDecimal angleB, BigDecimal angleC)
    {
        BigDecimal pi = new BigDecimal("3.14159265358980");
        BigDecimal angleSum = new BigDecimal("180");
        BigDecimal angleAtoRadians = angleA.multiply(pi).divide(angleSum, 2, RoundingMode.HALF_UP);
        BigDecimal angleBtoRadians = angleB.multiply(pi).divide(angleSum, 2, RoundingMode.HALF_UP);
        BigDecimal angleCtoRadians = angleC.multiply(pi).divide(angleSum, 2, RoundingMode.HALF_UP);
        Triangle triangle = new Triangle(a, b, c,
                angleAtoRadians,
                angleBtoRadians,
                angleCtoRadians);
        Triangle.builder()
                .area(triangle.calcArea())
                .per(triangle.calcPer())
                .med(triangle.calcMed())
                .bess(triangle.calcBess())
                .height(triangle.calcHeight())
                .inCircle(triangle.inCircleArea())
                .outCircle(triangle.outCircleArea())
                .typeTriangle(triangle.getType())
                .angleA(triangle.getAngleA())
                .angleB(triangle.getAngleB())
                .angleC(triangle.getAngleC())
                .testErr(triangle.getTestErr());
        TriangleDTO result = mapper.getMapper().map(triangle, TriangleDTO.class);
        if(triangle.getTypeTriangle().equals("Прямоугольный")) {
            RecTangle recTangle = new RecTangle();
            result.setCos(recTangle.calcCosRec(triangle.getAngleA()));
            result.setSin(recTangle.calcSinRec(triangle.getAngleA()));
            result.setTang(recTangle.calcTanRec(triangle.getAngleA()));
            result.setSinDegrees(recTangle.calcSinRecDegrees());
            result.setCosDegrees(recTangle.calcCosRecDegrees());
            result.setTangDegrees(recTangle.calcTangRecDegrees());
            mapper.getMapper().map(recTangle, TriangleDTO.class);
        }
        return result;
    }
}