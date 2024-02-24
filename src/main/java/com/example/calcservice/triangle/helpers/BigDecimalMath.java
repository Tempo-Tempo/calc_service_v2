package com.example.calcservice.triangle.helpers;

import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalMath {
    @Bean
    public BigDecimal cosine(BigDecimal angle) {
        BigDecimal cosine = BigDecimal.valueOf(Math.cos(angle.doubleValue()));
    return cosine.round(new MathContext(5, RoundingMode.HALF_UP));
    }
    @Bean
    public BigDecimal sinus(BigDecimal angle) {
        BigDecimal sinus = BigDecimal.valueOf(Math.sin(angle.doubleValue()));
        return sinus.round(new MathContext(5, RoundingMode.HALF_UP));
    }
    @Bean
    public BigDecimal arcSinus(BigDecimal angle) {
        BigDecimal arcSinus = BigDecimal.valueOf(Math.asin(angle.doubleValue()));
        return arcSinus.round(new MathContext(5, RoundingMode.HALF_UP));
    }
    @Bean
    public BigDecimal arcCosine(BigDecimal angle) {
        BigDecimal arcCosine = BigDecimal.valueOf(Math.acos(angle.doubleValue()));
        return arcCosine.round(new MathContext(5, RoundingMode.HALF_UP));
    }
}

