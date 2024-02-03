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

    @Autowired
    MapperConfig mapper = new MapperConfig();
    ModelMapper modelMapper = new ModelMapper();
    @Override
    public TriangleDTO resultCalcTriangle(double a, double b ,double c) {
        resultCalcRecTangle();
        Triangle triangle = new Triangle(a, b, c);
        Triangle.builder()
                .area(triangle.calcArea())
                .per(triangle.calcPer())
                .typeTriangle(triangle.getType())
                .med(triangle.calcMed())
                .bess(triangle.calcBess())
                .inCircle(triangle.inCircleArea())
                .outCircle(triangle.outCircleArea());
        TriangleDTO triangleDTO = mapper.getMapper().map(triangle, TriangleDTO.class);
        TriangleDTO result = triangleDTO;
        System.out.println("Area: " + triangleDTO);
        return result;
    }
    @Override
    public void resultCalcRecTangle() {
       RecTangle recTangle = new RecTangle(40, 90);
        MapperConfig mapper = new MapperConfig();
    }
}