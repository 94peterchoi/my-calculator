package calc.calculator;

import calc.service.*;
import calc.utility.CalcUtil;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/* 후위연산 계산기 클래스 */
public class PostfixCalc implements Calculator{

    private final Converter converter;
    private final Operation operation;
    private static PostfixCalc postfixCalc;

    private PostfixCalc() {
        this.converter = ConverterFactory.createPostfixConverter();
        this.operation = new Operation();
    }

    @Override
    public String getInput() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        System.out.print("수식을 입력하세요(종료하려면 q): ");

        userInput = scan.nextLine();
        if (userInput.equals("q")) {
            System.out.println("*******계산기를 종료합니다*******");
            System.exit(0);
        }

        return userInput.replaceAll(" ", "");
    }

    @Override
    public double calculate(String userInput) throws Exception {
        Stack<Double> numStack = new Stack<>();
        List<String> postfix;

        // 입력받은 문자열을 후위식으로 바꾼다
        postfix = converter.convert(userInput);

        // 후위연산 수행
        int i = 0;
        while(i < postfix.size()) {
            String letter = postfix.get(i);

            if (CalcUtil.isOperator(letter)) {
                numStack.push(operation.operate(numStack, letter));
                i++;
                continue;
            }

            if (CalcUtil.isValidNumber(letter)) {
                numStack.push(Double.parseDouble(letter));
                i++;
            }
        }
        return numStack.pop();
    }

    @Override
    public void printResult(double result) {
        if (CalcUtil.isInteger(result)) {
            System.out.println("연산결과는 " + (int)result + "입니다.");
            return;
        }

        double res = Math.floor(result * 1000) / 1000.0;    // 소수점 세자리 아래로 버림
        System.out.println("연산결과는 " + res + " 입니다.");
    }


    public static Calculator getInstance() {
        if (postfixCalc == null) {
            postfixCalc = new PostfixCalc();
        }
        return postfixCalc;
    }

}
