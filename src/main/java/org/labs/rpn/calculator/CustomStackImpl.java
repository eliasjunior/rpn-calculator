package org.labs.rpn.calculator;

import org.labs.rpn.util.CustomFormatUtil;

import java.util.ArrayDeque;
import java.util.Deque;

public class CustomStackImpl implements CustomStack<Double> {
    private Deque<Double> stack;
    private Deque<Double> numberPopTracker;
    private Deque<String> operatorTracker;
    private CustomFormatUtil customFormatUtil;

    public CustomStackImpl(Deque<Double> stack, Deque<Double> numberPopTracker, Deque<String> operatorTracker,
                           CustomFormatUtil customFormatUtil) {
        // passing the stack here as we could use another stack implementation under Deque hierarchy
        this.stack = stack;
        this.numberPopTracker = numberPopTracker;
        this.operatorTracker = operatorTracker;
        this.customFormatUtil = customFormatUtil;
    }

    @Override
    public void push(Double element) {
        this.stack.push(element);
    }

    @Override
    public Double pop() {
        if(stack.isEmpty()){
            throw new IllegalStateException("Attempt to remove item from stack has failed, stack is empty");
        }
        numberPopTracker.push(stack.pop());
        return numberPopTracker.peek();
    }

    @Override
    public void undo() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Attempt to execute undo has failed, stack is empty");
        }
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
    }

    @Override
    public void operatorHistory(String op) {
        this.operatorTracker.push(op);
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public String toString() {
        if (stack == null) {
            return "";
        }
        Deque<Double> aux = new ArrayDeque<>();
        for (Double num : stack) {
            aux.push(num);
        }
        StringBuilder result = new StringBuilder();
        for (Double num: aux) {
            result.append(customFormatUtil.formatNumber(num)).append(" ");
        }
        return result.toString().trim();
    }
}
