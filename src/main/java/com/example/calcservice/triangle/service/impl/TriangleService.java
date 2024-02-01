package com.example.calcservice.triangle.service.impl;
import com.example.calcservice.triangle.model.RecTriangle;
import com.example.calcservice.triangle.model.Triangle;
import com.example.calcservice.triangle.service.TriangleInterface;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TriangleService implements TriangleInterface {
    @Override
    public Map<String, Double> resultCalcTriangle(double[] a) {
        System.out.println(a);
        Triangle triangle = new Triangle(a);
        Map<String, Double> result = new HashMap<>();
        // Если прямоугольный треугольник то выполняем еще и resultCalcRecTriangle();
//         if(triangle.getType().equals("Прямоугольный")) {
//            resultCalcRecTriangle();
//        }
        System.out.println(Triangle.builder().triangleType(triangle.getType()));
        result.put(triangle.getKeyArea(), triangle.calcArea());
        result.put(triangle.getKeyPer(), triangle.calcPer());
        result.put(triangle.getKeyMed(), triangle.calcMed());
        result.put(triangle.getKeyBess(), triangle.calcBess());
        result.put(triangle.getGetKeyInCircle(), triangle.inCircleArea());
        result.put(triangle.getGetKeyOutCircle(), triangle.outCircleArea());

        // Второй параметр в map Double, поэтому мы не можем строку передать,
        // придется это все делать не через мап, и наверное ключи созданные тоже удалять
        // result.put(triangle.getKeyType(), triangle.getType());
        return result;
    }
    @Override
    public Map<String, Double> resultCalcRecTriangle() {
        RecTriangle recTriangle = new RecTriangle(90, 45, 45);
        Map<String, Double> result = new HashMap<>();
        result.put(recTriangle.getKeyRecArea(), recTriangle.calcArea());
        return result;
    }
}