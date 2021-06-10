package org.labs.rpn.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface CustomFormatUtil {
    default String formatNumber(Double num) {
        Double fraction = Double.valueOf(getFractionPartFromFloat(num));
        if(fraction > 0) {
            // TODO review here
            if(getFractionPartFromFloat(num).length() < 3) {
                return String.valueOf(num);
            } else {
                return format(10, num);
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
