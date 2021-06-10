package org.labs.rpn;

import org.junit.jupiter.api.Test;
import org.labs.rpn.calculator.RPNCalculator;
import org.labs.rpn.calculator.StackFactory;
import org.labs.rpn.exceptions.CustomOperationException;
import org.labs.rpn.validator.InputValidator;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.labs.rpn.util.Constants.*;

public class RPNCalculatorTest {
    RPNCalculator rpnCalculator = new RPNCalculator(new StackFactory().createCustomStack(), new InputValidator());

    @Test
    public void testShouldThrowErrorWhenInputIsNotValid() {
        assertThrows(CustomOperationException.class, () -> {
            rpnCalculator.execute(Arrays.asList("2", "magic"));
        });
        assertThrows(CustomOperationException.class, () -> {
            rpnCalculator.execute(Arrays.asList("t","abc"));
        });
    }

    @Test
    public void testExample2() {
        rpnCalculator.execute(Arrays.asList("2", SQUARE_ROOT));
        assertEquals("1.4142135623", rpnCalculator.print());
        rpnCalculator.execute(Arrays.asList(CLEAR, "9", SQUARE_ROOT));
        assertEquals("3", rpnCalculator.print());
    }

    @Test
    public void testExample3() {
        rpnCalculator.execute(Arrays.asList("5", "2", SUBTRACT));
        assertEquals("3", rpnCalculator.print());

        rpnCalculator.execute(Arrays.asList("3", SUBTRACT));
        assertEquals("0", rpnCalculator.print());

        rpnCalculator.execute(Arrays.asList(CLEAR));
        assertEquals("", rpnCalculator.print());
    }

    @Test
    public void testExample4() {
        rpnCalculator.execute(Arrays.asList("5", "4", "3", "2"));
        assertEquals("5 4 3 2", rpnCalculator.print());
        rpnCalculator.execute(Arrays.asList(UNDO, UNDO, MULTIPLY));
        assertEquals("20", rpnCalculator.print());
        rpnCalculator.execute(Arrays.asList("5", MULTIPLY));
        assertEquals("100", rpnCalculator.print());
        rpnCalculator.execute(Arrays.asList(UNDO));
        assertEquals("20 5", rpnCalculator.print());
    }

    @Test
    public void testExample5() {
        rpnCalculator.execute(Arrays.asList("7", "12", "2", DIVIDE));
        assertEquals("7 6", rpnCalculator.print());
        rpnCalculator.execute(Arrays.asList(MULTIPLY));
        assertEquals("42", rpnCalculator.print());
        rpnCalculator.execute(Arrays.asList("4", DIVIDE));
        assertEquals("10.5", rpnCalculator.print());
    }

    @Test
    public void testExample6() {
        rpnCalculator.execute(Arrays.asList("1", "2", "3", "4", "5"));
        assertEquals("1 2 3 4 5", rpnCalculator.print());
        rpnCalculator.execute(Arrays.asList(MULTIPLY));
        assertEquals("1 2 3 20", rpnCalculator.print());
        rpnCalculator.execute(Arrays.asList(CLEAR, "3", "4", SUBTRACT));
        assertEquals("-1", rpnCalculator.print());
    }

    @Test
    public void testExample7() {
        rpnCalculator.execute(Arrays.asList("1", "2", "3", "4", "5"));
        assertEquals("1 2 3 4 5", rpnCalculator.print());
        rpnCalculator.execute(Arrays.asList(MULTIPLY, MULTIPLY, MULTIPLY, MULTIPLY));
        assertEquals("120", rpnCalculator.print());
    }

    @Test
    public void testExample8() {
        assertThrows(CustomOperationException.class, () -> {
            rpnCalculator.execute(Arrays.asList("1", "2", "3", MULTIPLY, "5", SUM, MULTIPLY, MULTIPLY, "6", "5"));
        });
    }
}
