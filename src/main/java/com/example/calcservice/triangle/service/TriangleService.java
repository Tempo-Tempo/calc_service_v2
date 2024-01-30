package com.example.calcservice.triangle.service;
import com.example.calcservice.triangle.model.RecTriangle;
import com.example.calcservice.triangle.model.Triangle;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TriangleService  {
    public Map<String, Double> resultCalcTriangle() {
       Triangle triangle = new Triangle(60, 60, 60, 5);
        Map<String, Double> result = new HashMap<>();
        // Если прямоугольный треугольник то выполняем еще и resultCalcRecTriangle();
//         if(triangle.getType().equals("Прямоугольный")) {
//            resultCalcRecTriangle();
//        }
        System.out.println(Triangle.builder().triangleType(triangle.getType()));
        result.put(triangle.getKeyArea(), triangle.calcArea());
        result.put(triangle.getKeyPer(), triangle.calcPer());
        result.put(triangle.getKeyMed(), triangle.getTriangleMed());
        result.put(triangle.getKeyBess(), triangle.getTriangleBess());
        // Второй параметр в map Double, поэтому мы не можем строку передать,
        // придется это все делать не через мап, и наверное ключи созданные тоже удалять
        // result.put(triangle.getKeyType(), triangle.getType());
        return result;
    }
    public Map<String, Double> resultCalcRecTriangle() {
        RecTriangle recTriangle = new RecTriangle(4, 5, 6, 8);
        Map<String, Double> result = new HashMap<>();
        result.put(recTriangle.getKeyRecArea(), recTriangle.calcArea());
        return result;
    }
}
