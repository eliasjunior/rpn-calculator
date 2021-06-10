package org.labs.rpn.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomFormatUtilTest {

    @Test
    void formatNumber() {
        CustomFormatUtil customFormatUtil = new CustomFormatUtil() {
            @Override
            public String formatNumber(Double num) {
                return CustomFormatUtil.super.formatNumber(num);
            }
        };
        assertEquals("1.4142135623", customFormatUtil.formatNumber(Math.sqrt(2)));
        assertEquals("10.5", customFormatUtil.formatNumber(42.0/4.0));
    }
}