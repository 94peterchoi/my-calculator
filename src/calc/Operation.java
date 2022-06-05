package calc;

import java.util.Stack;

public class Operation {

    public double operate(Stack<Double> numStack, String op) {

        // 언더플로우
        // 너무 큰 숫자

        double secondNum = numStack.pop();
        double firstNum = numStack.pop();

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

        // 아무것도 if문 안 타면 에러 내뱉기 (존재하지 않는 연산자)
        return 0;
    }
}
