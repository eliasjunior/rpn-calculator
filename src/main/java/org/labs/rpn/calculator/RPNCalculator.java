package org.labs.rpn.calculator;

import org.labs.rpn.exceptions.CustomOperationException;
import org.labs.rpn.validator.Validator;

import java.util.List;

import static org.labs.rpn.util.Constants.*;

public class RPNCalculator {
    private final CustomStack<Double> customStack;
    private final Validator validator;

    public RPNCalculator(CustomStack<Double> customStack, Validator validator) {
        this.customStack = customStack;
        this.validator = validator;
    }

    public void execute(List<String> cmdList) {
        for (String element : cmdList) {
            validator.validate(element);
            if (validator.isNumber(element)) {
                customStack.push(Double.valueOf(element));
            } else {
                executeOperator(element);
            }
        }
    }

    public String print() {
        return customStack.toString();
    }

    private void executeOperator(String operator) {
        BasicOperator<Double> numberBasicOperator = new BasicOperatorImpl();
        Double result;
        double[] numbers;
        switch (operator) {
            case SUM:
                numbers = pop2Numbers();
                result = numberBasicOperator.sum(numbers[0], numbers[1]);
                customStack.push(result);
                customStack.operatorHistory(operator);
                break;
            case SUBTRACT:
                numbers = pop2Numbers();
                result = numberBasicOperator.subtract(numbers[1], numbers[0]);
                customStack.push(result);
                customStack.operatorHistory(operator);
                break;
            case MULTIPLY:
                numbers = pop2Numbers();
                result = numberBasicOperator.multiply(numbers[0], numbers[1]);
                customStack.push(result);
                customStack.operatorHistory(operator);
                break;
            case DIVIDE:
                numbers = pop2Numbers();
                result = numberBasicOperator.divide(numbers[1], numbers[0]);
                customStack.push(result);
                customStack.operatorHistory(operator);
                break;
            case SQUARE_ROOT:
                Double sqrtNum = customStack.pop();
                customStack.push(numberBasicOperator.sqrt(sqrtNum));
                break;
            case CLEAR:
                customStack.clear();
                break;
            case UNDO:
                customStack.undo();
                break;
//            default:
//                //TODO review if should throw a checked exception for recovery
//                throw new RuntimeException("Illegal Operation");
        }
    }


    private double[] pop2Numbers() {
        Double num1, num2;
        if (!customStack.isEmpty()) {
            num1 = customStack.pop();
        } else {
            throw new CustomOperationException("Insufficient parameters");
        }
        if (!customStack.isEmpty()) {
            num2 = customStack.pop();
        } else {
            throw new CustomOperationException("Insufficient parameters");
        }
        return new double[]{num1, num2};
    }

}
