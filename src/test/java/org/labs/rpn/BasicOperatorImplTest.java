package org.labs.rpn;

import org.junit.jupiter.api.Test;
import org.labs.rpn.calculator.BasicOperator;
import org.labs.rpn.calculator.BasicOperatorImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicOperatorImplTest {

    @Test
    public void basicOperations() {
        BasicOperator<Double> basicOperator = new BasicOperatorImpl();
        assertEquals(4,  basicOperator.sum(2.0, 2.0));
        assertEquals(4.0,  basicOperator.sum(2.0, 2.0));
        assertEquals(7.5,  basicOperator.sum(3.5, 4.0));
    }
}