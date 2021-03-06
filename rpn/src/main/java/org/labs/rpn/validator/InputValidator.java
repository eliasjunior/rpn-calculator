package org.labs.rpn.validator;

import org.labs.rpn.exceptions.InputValidationException;

import static org.labs.rpn.util.Constants.*;

public class InputValidator implements Validator {
    @Override
    public void validate(String input) throws InputValidationException {
        boolean isInValid = !isNumber(input) && !isValidCommand(input);
        if (isInValid) {
            throw new InputValidationException("Operator " + input + " is not valid!");
        }
    }

    private boolean isValidCommand(String element) {
        return element.equals(UNDO) ||
                element.equals(CLEAR) ||
                element.equals(SUBTRACT) ||
                element.equals(SUM) ||
                element.equals(MULTIPLY) ||
                element.equals(DIVIDE) ||
                element.equals(SQUARE_ROOT);
    }

    public boolean isNumber(String element) {
        String regex = "\\d+";
        return element.matches(regex);
    }
}
