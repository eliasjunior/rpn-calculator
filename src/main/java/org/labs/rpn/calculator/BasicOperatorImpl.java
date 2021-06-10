package org.labs.rpn.calculator;

public class BasicOperatorImpl implements BasicOperator<Double> {
    @Override
    public Double sum(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double subtract(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double multiply(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double divide(Double a, Double b) {
        return a/b;
    }

    @Override
    public Double sqrt(Double a) {
       return Math.sqrt(a);
    }
}
