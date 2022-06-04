package calc;

import java.util.Stack;

public class Operation {

    public double operate(Stack<Double> numStack, String op) {

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
            // 0으로 나눠졌을 때 에러처리 해야 함
            if (secondNum == 0) {

            }
            // 아리스메틱 익셉션 내뱉기
            return firstNum / secondNum;
        }

        // 아무것도 if문 안 타면 에러 내뱉기 (존재하지 않는 연산자)
        return 0;
    }
}
