package com.example.calcservice.triangle.service.impl;
import com.example.calcservice.config.MapperConfig;
import com.example.calcservice.triangle.model.RecTangle;
import com.example.calcservice.triangle.model.Triangle;
import com.example.calcservice.triangle.model.TriangleDTO;
import com.example.calcservice.triangle.service.TriangleInterface;
import org.springframework.stereotype.Service;

@Service
public class TriangleService implements TriangleInterface {
    MapperConfig mapper = new MapperConfig();
    @Override
    public TriangleDTO resultCalcTriangle(double a, double b, double c,
                                          double angleA, double angleB, double angleC)
    {
        Triangle triangle = new Triangle(a, b, c,
                Math.toRadians(angleA),
                Math.toRadians(angleB),
                Math.toRadians(angleC));
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