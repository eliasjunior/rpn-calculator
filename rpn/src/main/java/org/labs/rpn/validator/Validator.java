package org.labs.rpn.validator;

public interface Validator {
    void validate(String input);
    boolean isNumber(String input);
}
