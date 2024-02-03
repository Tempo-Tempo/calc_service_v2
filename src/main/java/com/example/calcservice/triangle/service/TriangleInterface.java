package com.example.calcservice.triangle.service;
import com.example.calcservice.triangle.model.Triangle;
import com.example.calcservice.triangle.model.TriangleDTO;

import java.util.*;


public interface TriangleInterface {
    TriangleDTO resultCalcTriangle(double a, double b, double c);
    void resultCalcRecTangle();

}
