package com.example.calcservice.triangle.service.impl;
import com.example.calcservice.config.MapperConfig;
import com.example.calcservice.triangle.model.RecTangle;
import com.example.calcservice.triangle.model.RecTangleDTO;
import com.example.calcservice.triangle.model.Triangle;
import com.example.calcservice.triangle.model.TriangleDTO;
import com.example.calcservice.triangle.service.TriangleInterface;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TriangleService implements TriangleInterface {
    @Override
    public Triangle resultCalcTriangle(double a, double b ,double c) {
        resultCalcRecTangle();
        resultCalcTest(a, b, c);
        Triangle triangle = new Triangle(a, b, c);
        return Triangle.builder().
                area(triangle.calcArea())
                .per(triangle.calcPer())
                .triangleType(triangle.getType())
                .med(triangle.calcMed())
                .bess(triangle.calcBess())
                .inCircle(triangle.inCircleArea())
                .outCircle(triangle.outCircleArea())
                .build();
    }
    @Override
    public void resultCalcRecTangle() {
       RecTangle recTangle = new RecTangle(40, 90);
        MapperConfig mapper = new MapperConfig();
        RecTangleDTO recTangleDTO = mapper.getMapper().map(recTangle, RecTangleDTO.class);
        //System.out.println("Width: " + recTangleDTO.getWeight());
       // System.out.println("Height: " + recTangleDTO.getHeight());
       // recTangleDTO.setArea(recTangleDTO.getWeight() * recTangleDTO.getHeight());
       // System.out.println("Area: " + recTangleDTO.getArea());
    }

    public void resultCalcTest(double a, double b, double c) {
        Triangle triangle = new Triangle(a, b, c);
        MapperConfig mapper = new MapperConfig();
        TriangleDTO triangleDTO = mapper.getMapper().map(triangle, TriangleDTO.class);
          System.out.println("Area: " + triangleDTO.getArea());
//        System.out.println("AreaT: " + triangle.getArea());
          System.out.println("Per: " + triangleDTO.getPer());
    }
}