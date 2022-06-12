package calc;

import calc.calculator.Calculator;
import calc.service.CalculatorFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = chooseCalcType();

        while (true)
            execute(calculator);

        /* 테스트 */
//        formulaChange.toPostfix("11*12*13+14-15/16*17+18/19+223");
//        formulaChange.toPostfix("1/2/3/4");
//        formulaChange.toPostfix("1/2/3/4+5*7");
//        formulaChange.toPostfix("6/3/1*4");

//        CalcUtil.isValidNumber("143.");

    }

    public static void execute(Calculator calc) {
        try {
            String userInput = calc.getInput();
            double result = calc.calculate(userInput);
            calc.printResult(result);
        } catch(Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            System.out.println();   // 줄바꿈
        }
    }


    public static Calculator chooseCalcType() {
        System.out.println("원하는 계산기 종류를 입력하세요.");
        System.out.println("A - 후위연산 계산기");
        System.out.println("B - 구현 예정");
        System.out.println("C - 구현 예정");

        Scanner scan = new Scanner(System.in);
        Calculator calculator;

        while(true) {
            String calcType = scan.nextLine();
            calculator = CalculatorFactory.getCalculator(calcType);
            if (calculator == null) {
                System.out.println("잘못 입력하였습니다. 현재는 A타입 계산기만 선택이 가능합니다.");
                continue;
            }
            break;
        }

        return calculator;
    }
}
