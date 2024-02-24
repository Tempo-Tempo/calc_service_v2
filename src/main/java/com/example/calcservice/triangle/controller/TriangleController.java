package com.example.calcservice.triangle.controller;
import com.example.calcservice.triangle.model.TriangleDTO;
import com.example.calcservice.triangle.service.TriangleInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin(origins = {"http://localhost:3000"})

@RestController
@RequestMapping("/api/triangle")
@AllArgsConstructor
@ResponseBody
public class TriangleController {
    private TriangleInterface triangleInterface;
    @GetMapping
    public TriangleDTO resultCalcTriangle(@RequestParam(defaultValue = "0")  BigDecimal a ,
                                          @RequestParam(defaultValue = "0")  BigDecimal b,
                                          @RequestParam(defaultValue = "0")  BigDecimal c,
                                          @RequestParam(defaultValue = "0")  BigDecimal angleA,
                                          @RequestParam(defaultValue = "0")  BigDecimal angleB,
                                          @RequestParam(defaultValue = "0")  BigDecimal angleC)
    {
        return triangleInterface.resultCalcTriangle(a, b, c, angleA, angleB, angleC);
    }

}
