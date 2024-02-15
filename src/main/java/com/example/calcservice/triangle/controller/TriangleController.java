package com.example.calcservice.triangle.controller;
import com.example.calcservice.triangle.model.TriangleDTO;
import com.example.calcservice.triangle.service.TriangleInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000"})

@RestController
@RequestMapping("/api/triangle")
@AllArgsConstructor
@ResponseBody
public class TriangleController {
    private TriangleInterface triangleInterface;
    @GetMapping
    public TriangleDTO resultCalcTriangle(@RequestParam(defaultValue = "0")  double a,
                                          @RequestParam(defaultValue = "0")  double b,
                                          @RequestParam(defaultValue = "0")  double c,
                                          @RequestParam(defaultValue = "0")  double angleA,
                                          @RequestParam(defaultValue = "0")  double angleB,
                                          @RequestParam(defaultValue = "0")  double angleC)
    {
        return triangleInterface.resultCalcTriangle(a, b, c, angleA, angleB, angleC);
    }

}
