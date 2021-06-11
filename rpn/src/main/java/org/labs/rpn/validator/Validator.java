package org.labs.rpn.validator;

import org.labs.rpn.exceptions.InputValidationException;

public interface Validator {
    void validate(String input) throws InputValidationException;
    boolean isNumber(String input);
}
