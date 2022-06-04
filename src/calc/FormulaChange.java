package calc;

import java.util.*;

public class FormulaChange {
    // 중위연산 -> 후위연산
    // 에러처리 필수
    Stack<String> output = new Stack<>();
    Stack<String> operators = new Stack<>();
    String postfix = "";

    public String toPostfix(String formula) {

        int i = 0;

        // 연산자랑 한자리 숫자는 괜찮은데 숫자가 2자리 이상일 때 처리로직 필요함 (흠 ..)
        while(i < formula.length()) {
            String letter = formula.substring(i, i+1);

            // 돌아다니면서 순서대로 곱셈 나눗셈 먼저 빼온다
            // 다시 돌아다니면서 순서대로 덧셈 뺄셈 빼온다
            // 처음에만 2개 숫자 빼고, 나머지 경우는 1개만 빼면 됨

            if (CalcUtil.isNumber(letter)) {
                output.push(letter);
            }

            if (CalcUtil.isOperator(letter)) {
                checkOperator(letter);
            }

            i++;
        }

        // 연산자 스택에 남아있는 연산자가 있을 시
        if (operators.size() > 0) {
            int size = operators.size();
            for (int j=0; j<size; j++) {
                output.push(operators.pop());
            }
        }

        return "";
    }

    // 연산자 체크 로직
    public void checkOperator(String op) {
        if (operators.isEmpty()) {
            operators.push(op);
            return;
        }

        if (operators.peek().equals("*") && op.equals("+")) {
            int size = operators.size();
            for (int i=0; i<size; i++) {
                output.push(operators.pop());
            }
            operators.push(op);
            return;
        }

        if (operators.peek().equals(op)) {
            output.push(operators.pop());
            operators.push(op);
            return;
        }

        operators.push(op);

    }

}
