package com.example.calcservice.triangle.controller;

import com.example.calcservice.triangle.service.TriangleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/triangle")
@AllArgsConstructor

public class TriangleController {
    private TriangleService service;
    @GetMapping
    public Map<String, Double> resultCalcTriangle()
    {
        System.out.println("suka");
        return service.resultCalcTriangle();
    }

}
