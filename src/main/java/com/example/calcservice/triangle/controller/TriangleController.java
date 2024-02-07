package com.example.calcservice.triangle.controller;
import com.example.calcservice.triangle.model.TriangleDTO;
import com.example.calcservice.triangle.service.TriangleInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000"})

@RestController
@RequestMapping("/api/v1/triangle")
@AllArgsConstructor
@ResponseBody
public class TriangleController {
    private TriangleInterface triangleInterface;
    @GetMapping
    public TriangleDTO resultCalcTriangle(@RequestParam(required = false, defaultValue = "0")  double a,
                                          @RequestParam(required = false, defaultValue = "0")  double b,
                                          @RequestParam(required = false, defaultValue = "0")  double c,
                                          @RequestParam(required = false, defaultValue = "0")  double angleA,
                                          @RequestParam(required = false, defaultValue = "0")  double angleB,
                                          @RequestParam(required = false, defaultValue = "0")  double angleC)
    {
        return triangleInterface.resultCalcTriangle(a, b, c, angleA, angleB, angleC);
    }

}
