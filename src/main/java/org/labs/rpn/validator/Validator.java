package org.labs.rpn.validator;

import org.labs.rpn.exceptions.CustomOperationException;

public interface Validator {
    void validate(String input);
    boolean isNumber(String input);
}
