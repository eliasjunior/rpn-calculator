package org.labs.rpn.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicOperatorImplTest {

    @Test
    public void testBasicOperations() {
        BasicOperator<Double> basicOperator = new BasicOperatorImpl();
        assertEquals(4, basicOperator.sum(2.0, 2.0));
        assertEquals(-3, basicOperator.subtract(2.0, 5.0));
        assertEquals(1, basicOperator.subtract(5.0, 4.0));
        assertEquals(1, basicOperator.divide(3.0, 3.0));
        assertEquals(2, basicOperator.sqrt(4.0));
        assertThrows(RuntimeException.class, () -> basicOperator.divide(3.0, 0.0));
        assertEquals(9, basicOperator.multiply(3.0, 3.0));
    }
}