package org.labs.rpn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.labs.rpn.calculator.CustomStack;
import org.labs.rpn.calculator.StackFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomStackImplTest {
    CustomStack customStack = StackFactory.createCustomStack();

    @BeforeEach
    public void clear() {
        customStack.clear();
    }

    @Test
    public void testInvalidInputs() {
        assertEquals("", customStack.toString());
    }

    @Test
    public void testHandleDoubleAndIntegers() {
        customStack.push(5.0);
        customStack.push(2.0);
        customStack.push(0.0);
        assertEquals("5 2 0", customStack.toString());
    }
    @Test
    public void testShouldThrowAFriendlyMessageWhenThereIsNoValue() {
        assertThrows(IllegalStateException.class, () -> {
            customStack.pop();
        });
    }
}