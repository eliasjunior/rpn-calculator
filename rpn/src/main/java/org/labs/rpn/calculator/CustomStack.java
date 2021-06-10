package org.labs.rpn.calculator;

public interface CustomStack<T> {
    void add(T element, String operator);
    void add(T element);
    T remove();
    void undo();
    void clear();
    boolean isEmpty();
    String printStack();
}
