package org.labs.rpn.calculator;

public interface CustomStack<T> {
    void push(T element);
    T pop();
    void undo();
    void clear();
    boolean isEmpty();
    void operatorHistory(String op);
}
