package org.labs.rpn.calculator;

import org.labs.rpn.exceptions.CustomOperationException;
import org.labs.rpn.exceptions.InputValidationException;
import org.labs.rpn.validator.Validator;

import java.util.List;

import static org.labs.rpn.util.Constants.*;

public class OperatorManager {
    private final CustomStack<Double> customStack;
    private final Validator validator;
    private final BasicOperator<Double> numberBasicOperator;

    public OperatorManager(CustomStack<Double> customStack, BasicOperator<Double> numberBasicOperator,
                           Validator validator) {
        this.customStack = customStack;
        this.numberBasicOperator = numberBasicOperator;
        this.validator = validator;
    }

    public void execute(List<String> cmdList) {
        for (String element : cmdList) {
            try {
                validator.validate(element);
                if (validator.isNumber(element)) {
                    customStack.add(Double.valueOf(element));
                } else {
                    executeOperator(element);
                }
            } catch (InputValidationException e) {
                // recoverable error
                System.err.println(e.getLocalizedMessage());
            }
        }
    }

    public String print() {
        return  customStack.printStack();
    }

    private void executeOperator(String operator) {
        Double result;
        double[] numbers;
        switch (operator) {
            case SUM:
                numbers = pop2Numbers();
                result = numberBasicOperator.sum(numbers[0], numbers[1]);
                customStack.add(result, operator);
                break;
            case SUBTRACT:
                numbers = pop2Numbers();
                result = numberBasicOperator.subtract(numbers[1], numbers[0]);
                customStack.add(result, operator);
                break;
            case MULTIPLY:
                numbers = pop2Numbers();
                result = numberBasicOperator.multiply(numbers[0], numbers[1]);
                customStack.add(result, operator);
                break;
            case DIVIDE:
                numbers = pop2Numbers();
                result = numberBasicOperator.divide(numbers[1], numbers[0]);
                customStack.add(result, operator);
                break;
            case SQUARE_ROOT:
                Double sqrtNum = customStack.remove();
                customStack.add(numberBasicOperator.sqrt(sqrtNum));
                break;
            case CLEAR:
                customStack.clear();
                break;
            case UNDO:
                customStack.undo();
                break;
        }
    }

    private double[] pop2Numbers() {
        Double num1, num2;
        if (!customStack.isEmpty()) {
            num1 = customStack.remove();
        } else {
            throw new CustomOperationException("Insufficient parameters");
        }
        if (!customStack.isEmpty()) {
            num2 = customStack.remove();
        } else {
            throw new CustomOperationException("Insufficient parameters");
        }
        return new double[]{num1, num2};
    }
}
