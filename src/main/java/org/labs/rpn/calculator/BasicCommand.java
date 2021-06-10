package org.labs.rpn.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCommand implements StackManager {
    private Deque<String> history;
    private Deque<Double> stack;
    private Deque<Double> trackStackNumber;

    public BasicCommand(Deque<String> history) {
        this.history = history;
    }

    @Override
    public void history(String op) {
        this.history.push(op);
    }

    @Override
    public boolean isEmpty() {
        return this.history.isEmpty();
    }

    @Override
    public void undo() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Attempt to execute undo has failed, stack is empty");
        }
        if (!trackStackNumber.isEmpty() && !history.isEmpty()) {
            history.pop();
            stack.pop();
            //remove last 2 numbers
            stack.push(trackStackNumber.pop());
            stack.push(trackStackNumber.pop());
        } else {
            trackStackNumber.push(stack.pop());
        }
    }

    @Override
    public void clear() {
        stack = new ArrayDeque();
    }
}
