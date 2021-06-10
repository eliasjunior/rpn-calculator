package org.labs.rpn.calculator;

public interface StackManager {
    void history(String op);
    boolean isEmpty();
    void undo();
    void clear();
}
