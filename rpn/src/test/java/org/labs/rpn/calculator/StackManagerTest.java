package org.labs.rpn.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackManagerTest {
    @Test
    public void testInvalidInputs() {
        CustomStack<Double> customStack = RpnConfig.createStackManager();
        assertEquals("", customStack.printStack());
    }

    @Test
    public void testShouldPushDoubleButPrintIntegers() {
        CustomStack<Double> customStack = RpnConfig.createStackManager();
        customStack.add(5.0);
        customStack.add(2.0);
        customStack.add(0.0);
        assertEquals("5 2 0", customStack.printStack());
    }

    @Test
    public void testShouldThrowAFriendlyMessageWhenThereIsNoValue() {
        CustomStack<Double> customStack = RpnConfig.createStackManager();
        assertThrows(IllegalStateException.class, () -> customStack.remove());
        assertThrows(IllegalStateException.class, () -> customStack.undo());
    }

    @Test
    public void testShouldBeEmpty() {
        CustomStack<Double> customStack = RpnConfig.createStackManager();
        customStack.add(5.0);
        customStack.add(2.0);
        customStack.add(0.0);
        customStack.remove();
        customStack.remove();
        customStack.remove();

        assertTrue(customStack.isEmpty());
    }
}