package com.example.calcservice.triangle.service.impl;
import com.example.calcservice.config.MapperConfig;
import com.example.calcservice.triangle.model.RecTangle;
import com.example.calcservice.triangle.model.Triangle;
import com.example.calcservice.triangle.model.TriangleDTO;
import com.example.calcservice.triangle.service.TriangleInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriangleService implements TriangleInterface {
    MapperConfig mapper = new MapperConfig();
    @Override
    public TriangleDTO resultCalcTriangle(double a, double b, double c,
                                          double angleA, double angleB, double angleC)
    {
        Triangle triangle = new Triangle(a, b, c, angleA, angleB, angleC);
        Triangle.builder()
                .area(triangle.calcArea())
                .per(triangle.calcPer())
                .typeTriangle(triangle.getType())
                .med(triangle.calcMed())
                .bess(triangle.calcBess())
                .inCircle(triangle.inCircleArea())
                .outCircle(triangle.outCircleArea());
        TriangleDTO triangleDTO = mapper.getMapper().map(triangle, TriangleDTO.class);
        return triangleDTO;
    }
    @Override
    public void resultCalcRecTangle() {
//       RecTangle recTangle = new RecTangle(40, 90);
//        MapperConfig mapper = new MapperConfig();
    }
}