package org.labs.rpn.calculator;

import org.labs.rpn.util.CustomFormatUtil;

import java.util.ArrayDeque;

public class StackFactory {
    public static CustomStack<Double> createCustomStack() {
        CustomFormatUtil customFormatUtil = new CustomFormatUtil() {
            @Override
            public String formatNumber(Double num) {
                return CustomFormatUtil.super.formatNumber(num);
            }
        };
        return new StackManager(new ArrayDeque<>(), new ArrayDeque<>(), new ArrayDeque<>(), customFormatUtil);
    }
}
