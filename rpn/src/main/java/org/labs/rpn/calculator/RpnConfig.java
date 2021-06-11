package org.labs.rpn.calculator;

import org.labs.rpn.util.CustomFormatUtil;
import org.labs.rpn.validator.InputValidator;

import java.util.ArrayDeque;

//RpnConfig is to facilitate components creation, acts as a Factory

public class RpnConfig {
    public static CustomStack<Double> createStackManager() {
        CustomFormatUtil customFormatUtil = new CustomFormatUtil() {
            @Override
            public String formatNumber(Double num) {
                return CustomFormatUtil.super.formatNumber(num);
            }
        };
        return new StackManager(new ArrayDeque<>(), new ArrayDeque<>(), new ArrayDeque<>(), customFormatUtil);
    }

    public static BasicOperator<Double> createBasicOperator() {
        return new BasicOperatorImpl();
    }

    public static OperatorManager createOperatorManager() {
        return new OperatorManager(createStackManager(), createBasicOperator(), new InputValidator());
    }
}
