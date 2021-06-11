package org.labs.rpn.validator;

import org.junit.jupiter.api.Test;
import org.labs.rpn.exceptions.InputValidationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {

    @Test
    public void testShouldThrowErrorWhenInputIsNotValid() {
        InputValidator inputValidator = new InputValidator();
        assertThrows(InputValidationException.class, () -> {
            inputValidator.validate("magic");
            inputValidator.validate("abc");
        });
    }
}