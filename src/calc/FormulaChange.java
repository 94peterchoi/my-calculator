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

            if (CalcUtil.isNumber(letter) || letter.equals(".")) {
                strNum += letter;
            }

            if (CalcUtil.isOperator(letter)) {
                processStrNum(strNum);
                processStack(letter);
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

    // 문자열 형태의 숫자 처리 (정수, 실수)
    public void processStrNum(String strNum) {
        int decimalPointCnt = (int) strNum.chars().filter(c->c=='.').count();
        if (decimalPointCnt > 1) {
            // 에러 내뱉기
            System.out.println("잘못된 숫자입니다. 다시 입력하세요");
        }
        output.push(strNum);
        this.strNum = "";
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
