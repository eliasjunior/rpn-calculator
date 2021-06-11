package org.labs.rpn;

import org.labs.rpn.calculator.OperatorManager;
import org.labs.rpn.calculator.RpnConfig;

import java.util.Arrays;

public class RPNCalculator {
    OperatorManager operatorManager ;
    public RPNCalculator() {
        this.operatorManager = RpnConfig.createOperatorManager();
    }
    public void executeCommand(String [] values) {
        operatorManager.execute(Arrays.asList(values));
        System.out.println("Result: "+operatorManager.print());
    }
}
