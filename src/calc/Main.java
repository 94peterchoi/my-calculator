package calc;

import calc.calculator.Calculator;
import calc.calculator.PostfixCalc;

public class Main {
    public static void main(String[] args) {

        Calculator postfixCalc = new PostfixCalc();

        while (true)
            runCalc(postfixCalc);

        /* 테스트 */
//        formulaChange.toPostfix("11*12*13+14-15/16*17+18/19+223");
//        formulaChange.toPostfix("1/2/3/4");
//        formulaChange.toPostfix("1/2/3/4+5*7");
//        formulaChange.toPostfix("6/3/1*4");

//        CalcUtil.isValidNumber("143.");

    }

    public static void runCalc(Calculator calc) {
        try {
            String userFormula = calc.getInput();
            double result = calc.calculate(userFormula);
            calc.printResult(result);
        } catch(Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            System.out.println();   // 줄바꿈
        }
    }
}
