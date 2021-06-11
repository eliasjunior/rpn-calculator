package org.labs.rpn.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface CustomFormatUtil {
    // this method still basic and will need futures business decision to display more complex cases
    default String formatNumber(Double num) {
        final int MIN_PRECISION_DISPLAY = 10;
        final int MAX_READABLE_FRACTIONAL = 3;
        String fractionPartStr = getFractionPartFromFloat(num);
        Double fractionPart = Double.valueOf(fractionPartStr);
        if(fractionPart > 0) {
            if(fractionPartStr.length() < MAX_READABLE_FRACTIONAL) {
                return String.valueOf(num);
            } else {
                return format(MIN_PRECISION_DISPLAY, num);
            }
        } else {
            return String.valueOf(num.intValue());
        }
    }
    private String getFractionPartFromFloat(Double num) {
        String doubleAsStr = num.toString();
        return  doubleAsStr.substring(doubleAsStr.indexOf('.'));
    }

    private String format(int places, double num) {
        BigDecimal bd = new BigDecimal(num).setScale(places, RoundingMode.FLOOR);
        return bd.toString();
    }
}
