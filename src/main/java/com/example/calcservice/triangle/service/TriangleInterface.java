package com.example.calcservice.triangle.service;
import com.example.calcservice.triangle.model.Triangle;
import com.example.calcservice.triangle.model.TriangleDTO;

import java.math.BigDecimal;
import java.util.*;


public interface TriangleInterface {
    TriangleDTO resultCalcTriangle(BigDecimal a, BigDecimal b, BigDecimal c,
                                   BigDecimal angleA, BigDecimal angleB, BigDecimal angleC);

}
