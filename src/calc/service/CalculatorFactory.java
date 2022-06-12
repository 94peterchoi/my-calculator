package calc.service;

import calc.calculator.Calculator;
import calc.calculator.PostfixCalc;

public class CalculatorFactory {

    public static Calculator getCalculator(String type) {
        if (type.equals("A"))   // A: 후위연산 계산기
            return PostfixCalc.getInstance();
//        if (type.equals("B"))
//            return InfixCalc.getInstance();
//        if (type.equals("C"))
//            return PrefixCalc.getInstance();

        return null;
    }

}
