package com.example.calcservice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public abstract class Figure {
    protected BigDecimal a = new BigDecimal("0");
    protected BigDecimal b = new BigDecimal("0");
    protected BigDecimal c = new BigDecimal("0");
    protected final BigDecimal pi = new BigDecimal("3.14159265358980");

    public Figure() {}

    public abstract BigDecimal calcArea();
    public abstract BigDecimal calcPer();
}
