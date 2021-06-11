package org.labs.rpn.calculator;

import org.labs.rpn.util.CustomFormatUtil;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackManager implements CustomStack<Double> {
    private Deque<Double> stack;
    private Deque<Double> numberPopTracker;
    private Deque<String> operatorTracker;
    private CustomFormatUtil customFormatUtil;

    public StackManager(Deque<Double> stack, Deque<Double> numberPopTracker, Deque<String> operatorTracker,
                        CustomFormatUtil customFormatUtil) {
        // passing the stack here as we could use another stack implementation under Deque hierarchy
        this.stack = stack;
        this.numberPopTracker = numberPopTracker;
        this.operatorTracker = operatorTracker;
        this.customFormatUtil = customFormatUtil;
    }

    @Override
    public void add(Double element, String operator) {
        this.operatorTracker.push(operator);
        this.add(element);
    }

    @Override
    public void add(Double element) {
        this.stack.push(element);
    }

    @Override
    public Double remove() {
        checkStackEmpty("remove");
        numberPopTracker.push(stack.pop());
        return numberPopTracker.peek();
    }

    @Override
    public void undo() {
        checkStackEmpty("undo");
        if (!numberPopTracker.isEmpty() && !operatorTracker.isEmpty()) {
            operatorTracker.pop();
            stack.pop();
            //remove last 2 numbers
            stack.push(numberPopTracker.pop());
            stack.push(numberPopTracker.pop());
        } else {
            numberPopTracker.push(stack.pop());
        }
    }

    @Override
    public void clear() {
        stack = new ArrayDeque();
        numberPopTracker = new ArrayDeque<>();
        operatorTracker = new ArrayDeque<>();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public String printStack() {
        if (stack == null || stack.isEmpty()) {
            return "";
        }
        Deque<Double> aux = new ArrayDeque<>();
        for (Double num : stack) {
            aux.push(num);
        }
        StringBuilder result = new StringBuilder();
        for (Double num : aux) {
            result.append(customFormatUtil.formatNumber(num)).append(" ");
        }
        return result.toString().trim();
    }

    private void checkStackEmpty(String message) {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Attempt to " + message + " item from stack has failed, stack is empty");
        }
    }
}
