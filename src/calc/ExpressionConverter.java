package calc;

import java.util.*;

/* 식변환 클래스 */
public class ExpressionConverter {
    List<String> postfix = new ArrayList<>();
    Stack<String> operators = new Stack<>();
    String strNum = "";

    public List<String> toPostfix(String formula) throws Exception {

        int i = 0;

        while (i < formula.length()) {
            String letter = formula.substring(i, i + 1);

            if (CalcUtil.isNumber(letter) || letter.equals(".")) {
                strNum += letter;
                i++;
                continue;
            }

            if (CalcUtil.isOperator(letter)) {
                processStrNum(strNum);
                processStack(letter);
                i++;
                continue;
            }

            throw new Exception("[ERROR] 수식 오류1: 부적절한 문자");
        }

        // 남아있는 숫자와 연산자 처리
        if (!strNum.equals("")) {
            CalcUtil.isValidNumber(strNum);
            postfix.add(strNum);
        }

        int size = operators.size();
        for (int j = 0; j < size; j++) {
            postfix.add(operators.pop());
        }

        return postfix;
    }

    // 문자열 형태의 숫자 처리 (정수, 실수)
    public void processStrNum(String strNum) {
        if (!strNum.equals("")) {
            CalcUtil.isValidNumber(strNum);
            postfix.add(strNum);
            this.strNum = "";
        }
    }

    // 연산자에 따른 스택 처리
    public void processStack(String op) {
        if (operators.isEmpty()) {
            operators.push(op);
            return;
        }

        if (CalcUtil.isOpLevelOne(operators.peek()) && CalcUtil.isOpLevelTwo(op)) {
            int size = operators.size();
            for (int i = 0; i < size; i++) {
                postfix.add(operators.pop());
            }
            operators.push(op);
            return;
        }

        if (CalcUtil.isOpsSameLevel(operators.peek(), op)) {
            postfix.add(op);
            return;
        }

        operators.push(op);
    }


}
