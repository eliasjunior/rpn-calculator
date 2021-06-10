package org.labs.rpn.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackManagerTest {
    CustomStack customStack = StackFactory.createCustomStack();

    @BeforeEach
    public void clear() {
        customStack.clear();
    }

    @Test
    public void testInvalidInputs() {
        assertEquals("", customStack.printStack());
    }

    @Test
    public void testShouldPushDoubleButPrintIntegers() {
        customStack.add(5.0);
        customStack.add(2.0);
        customStack.add(0.0);
        assertEquals("5 2 0", customStack.printStack());
    }

    @Test
    public void testShouldThrowAFriendlyMessageWhenThereIsNoValue() {
        assertThrows(IllegalStateException.class, () -> {
            customStack.remove();
        });
        assertThrows(IllegalStateException.class, () -> {
            customStack.undo();
        });
    }

    @Test
    public void testShouldBeEmpty() {
        customStack.add(5.0);
        customStack.add(2.0);
        customStack.add(0.0);
        customStack.remove();
        customStack.remove();
        customStack.remove();

        assertTrue(customStack.isEmpty());
    }
}