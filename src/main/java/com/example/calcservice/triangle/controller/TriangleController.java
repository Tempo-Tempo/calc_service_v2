package com.example.calcservice.triangle.controller;
import com.example.calcservice.triangle.service.TriangleInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:3000"})

@RestController
@RequestMapping("/api/v1/triangle")
@AllArgsConstructor
@ResponseBody
public class TriangleController {
    private TriangleInterface triangleInterface;
    @GetMapping
    public Map<String, Double> resultCalcTriangle(@RequestParam double[] a) {
        System.out.println(Arrays.toString(a));
        System.out.println("alo");
        return triangleInterface.resultCalcTriangle(a);
    }

}
