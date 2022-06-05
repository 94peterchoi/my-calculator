package calc;

import java.util.*;

/* 식변환 클래스 */
public class ExpressionConverter {
    // 에러처리 필수!!
    List<String> postfix = new ArrayList<>();
    Stack<String> operators = new Stack<>();
    String strNum = "";

    public List<String> toPostfix(String formula) {

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
        postfix.add(strNum);
        int size = operators.size();

        for (int j = 0; j < size; j++) {
            postfix.add(operators.pop());
        }

        return postfix;
    }

    // 문자열 형태의 숫자 처리 (정수, 실수)
    public void processStrNum(String strNum) {
        int decimalPointCnt = (int) strNum.chars().filter(c->c=='.').count();
        if (decimalPointCnt > 1) {
            // 에러 내뱉기
            System.out.println("잘못된 숫자형식입니다. 다시 입력하세요");
        }
        postfix.add(strNum);
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


    // 중위연산식 유효성검사
    public static boolean isValidFormula(String userFormula) {
        /* 사칙연산 유효성검사 */
        // 2 + 3
        // 스택에 쌓는다
        // 꺼내면서 교차되는지 확인한다 (첫번째랑 끝요소는 당연히 숫자여야 하고)
        // makeInfixStack
        // checkInfixValid
        int i = 0;
        String strNum = "";
        List<String> infix = new ArrayList<>();

        while (i < userFormula.length()) {
            String letter = userFormula.substring(i, i+1);
            if (CalcUtil.isNumber(letter) || letter.equals(".")) {
                strNum += letter;
                if (i == userFormula.length() - 1) {
                    infix.add(strNum);
                }
                i++;
                continue;
            }
            if (!CalcUtil.isOperator(letter)) {
                System.out.println("가차없이 에러");
                System.exit(0);
            }
            if (CalcUtil.isOperator(letter)) {
                infix.add(strNum);
                infix.add(letter);
                strNum = "";
            }
            i++;
        }

        return checkInfixValid(infix);
    }

    private static boolean checkInfixValid(List<String> infix) {
        int i = 0;

        // 에러 (이항연산자 특성 상 짝수개로 나올 수 없음)
        if (infix.size() % 2 == 0) {
            System.out.println("수식 오류");
            System.exit(0);
        }

        while(i < infix.size()) {
            String letter = infix.get(i);
            boolean isNum = false;
            boolean isOp = false;

            if (i % 2 == 0)
                isNum = numberValidation(letter);
            if (i % 2 == 1)
                isOp = operatorValidation(letter);
            if (!isNum && !isOp)
                return false;

            i++;
        }

        return true;
    }

    private static boolean numberValidation(String letter) {
        if (!CalcUtil.isNumber(letter))
            return false;
        return true;
    }

    private static boolean operatorValidation(String letter) {
        if (!CalcUtil.isOperator(letter))
            return false;
        return true;
    }


}
