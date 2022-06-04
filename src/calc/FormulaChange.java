package calc;

import java.util.*;

/* 식변환 클래스 */
public class FormulaChange {
    // 중위연산 -> 후위연산
    // 에러처리 필수!!
    Stack<String> output = new Stack<>();
    Stack<String> operators = new Stack<>();
    String strNum = "";

    public String toPostfix(String formula) {

        int i = 0;

        while (i < formula.length()) {
            String letter = formula.substring(i, i + 1);

            if (CalcUtil.isNumber(letter)) {
                strNum += letter;
            }

            if (CalcUtil.isOperator(letter)) {
                output.push(strNum);
                strNum = "";
                checkOperator(letter);
            }

            i++;
        }

        // 남아있는 숫자와 연산자 처리
        output.push(strNum);
        int size = operators.size();

        for (int j = 0; j < size; j++) {
            output.push(operators.pop());
        }

        return "";
    }

    // 연산자 체크 로직 (체크 오퍼레이트가 과연 맞는 이름일까..? 이 로직이 하는 역할이 뭐지)
    public void checkOperator(String op) {
        if (operators.isEmpty()) {
            operators.push(op);
            return;
        }

        if (CalcUtil.isOpLevelOne(operators.peek()) && CalcUtil.isOpLevelTwo(op)) {
            int size = operators.size();
            for (int i = 0; i < size; i++) {
                output.push(operators.pop());
            }
            operators.push(op);
            return;
        }

        if (CalcUtil.isOpsSameLevel(operators.peek(), op)) {
            output.push(operators.pop());
            operators.push(op);
            return;
        }


        operators.push(op);

    }

}
