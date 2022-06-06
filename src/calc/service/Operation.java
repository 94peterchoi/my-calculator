package calc.service;

import java.util.EmptyStackException;
import java.util.Stack;

/* 연산 클래스 */
public class Operation {

    public double operate(Stack<Double> numStack, String op) throws Exception {

        double firstNum;
        double secondNum;

        try {
            secondNum = numStack.pop();
            firstNum = numStack.pop();
        } catch (EmptyStackException es) {
            throw new Exception("[ERROR] 수식 오류3: 산식 오류");
        }

        if (op.equals("+")) {
            return firstNum + secondNum;
        }
        if (op.equals("-")) {
            return firstNum - secondNum;
        }
        if (op.equals("*")) {
            return firstNum * secondNum;
        }
        if (op.equals("/")) {
            return firstNum / secondNum;
        }

        return 0;
    }
}
