package org.labs.rpn.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.labs.rpn.exceptions.CustomOperationException;
import org.labs.rpn.validator.InputValidator;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.labs.rpn.util.Constants.*;

public class OperatorManagerTest {
    @Test
    public void testShouldThrowErrorWhenInputIsNotValid() {
        OperatorManager operatorManager = create();
        assertThrows(CustomOperationException.class, () -> {
            operatorManager.execute(Arrays.asList("2", "magic"));
        });
        assertThrows(CustomOperationException.class, () -> {
            operatorManager.execute(Arrays.asList("t","abc"));
        });
    }

    @Test
    public void testExample2() {
        OperatorManager operatorManager = create();
        operatorManager.execute(Arrays.asList("2", SQUARE_ROOT));
        assertEquals("1.4142135623", operatorManager.print());
        operatorManager.execute(Arrays.asList(CLEAR, "9", SQUARE_ROOT));
        assertEquals("3", operatorManager.print());
    }

    @Test
    public void testExample3() {
        OperatorManager operatorManager = create();
        operatorManager.execute(Arrays.asList("5", "2", SUBTRACT));
        assertEquals("3", operatorManager.print());

        operatorManager.execute(Arrays.asList("3", SUBTRACT));
        assertEquals("0", operatorManager.print());

        operatorManager.execute(Arrays.asList(CLEAR));
        assertEquals("", operatorManager.print());
    }

    @Test
    public void testExample4() {
        OperatorManager operatorManager = create();
        operatorManager.execute(Arrays.asList("5", "4", "3", "2"));
        assertEquals("5 4 3 2", operatorManager.print());
        operatorManager.execute(Arrays.asList(UNDO, UNDO, MULTIPLY));
        assertEquals("20", operatorManager.print());
        operatorManager.execute(Arrays.asList("5", MULTIPLY));
        assertEquals("100", operatorManager.print());
        operatorManager.execute(Arrays.asList(UNDO));
        assertEquals("20 5", operatorManager.print());
    }

    @Test
    public void testExample5() {
        OperatorManager operatorManager = create();
        operatorManager.execute(Arrays.asList("7", "12", "2", DIVIDE));
        assertEquals("7 6", operatorManager.print());
        operatorManager.execute(Arrays.asList(MULTIPLY));
        assertEquals("42", operatorManager.print());
        operatorManager.execute(Arrays.asList("4", DIVIDE));
        assertEquals("10.5", operatorManager.print());
    }

    @Test
    public void testExample6() {
        OperatorManager operatorManager = create();
        operatorManager.execute(Arrays.asList("1", "2", "3", "4", "5"));
        assertEquals("1 2 3 4 5", operatorManager.print());
        operatorManager.execute(Arrays.asList(MULTIPLY));
        assertEquals("1 2 3 20", operatorManager.print());
        operatorManager.execute(Arrays.asList(CLEAR, "3", "4", SUBTRACT));
        assertEquals("-1", operatorManager.print());
    }

    @Test
    public void testExample7() {
        OperatorManager operatorManager = create();
        operatorManager.execute(Arrays.asList("1", "2", "3", "4", "5"));
        assertEquals("1 2 3 4 5", operatorManager.print());
        operatorManager.execute(Arrays.asList(MULTIPLY, MULTIPLY, MULTIPLY, MULTIPLY));
        assertEquals("120", operatorManager.print());
    }

    @Test
    public void testExample8() {
        OperatorManager operatorManager = create();
        assertThrows(CustomOperationException.class, () -> {
            operatorManager.execute(Arrays.asList("1", "2", "3", MULTIPLY, "5", SUM, MULTIPLY, MULTIPLY, "6", "5"));
        });
    }

    private OperatorManager create() {
        return new OperatorManager(new StackFactory().createCustomStack(), new BasicOperatorImpl(),
                new InputValidator());
    }
}
