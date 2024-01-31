package com.example.calcservice.triangle.controller;
import com.example.calcservice.triangle.service.TriangleInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000"})

@RestController
@RequestMapping("/api/v1/triangle")
@AllArgsConstructor
@ResponseBody
public class TriangleController {
    private TriangleInterface triangleInterface;
    @GetMapping
    public Map<String, Double> resultCalcTriangle(@RequestParam double a,
                                                  @RequestParam double b,
                                                  @RequestParam double c) {
        return triangleInterface.resultCalcTriangle(a, b, c);
    }

}
