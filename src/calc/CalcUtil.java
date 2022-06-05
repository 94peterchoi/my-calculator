package calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalcUtil {
    public static final String[] operators = {"+", "-", "*", "/"};
    public static final String[] OpsLevelOne = {"*", "/"};
    public static final String[] OpsLevelTwo = {"+", "-"};

    // 숫자인지 확인 (하나의 문자열만 처리할 수 있음)
    public static boolean isNumber(String s) {
        return !s.equals("") && isRealNumber(s.charAt(0));
    }

    // 실수 요소 확인
    private static boolean isRealNumber(Character ch) {
        return Character.isDigit(ch) || ".".equals(ch);
    }

    // 연산자인지 확인
    public static boolean isOperator(String operator) {
        return Arrays.stream(operators).anyMatch(op -> op.equals(operator));
    }

    // 연산자 우선순위1: 곱셈, 나눗셈
    public static boolean isOpLevelOne(String operator) {
        return Arrays.stream(OpsLevelOne).anyMatch(op -> op.equals(operator));
    }

    // 연산자 우선순위2: 덧셈, 뺄셈
    public static boolean isOpLevelTwo(String operator) {
        return Arrays.stream(OpsLevelTwo).anyMatch(op -> op.equals(operator));
    }

    // 같은 레벨의 연산자인지 확인
    public static boolean isOpsSameLevel(String op1, String op2) {
        return (isOpLevelOne(op1) == isOpLevelOne(op2)) || (isOpLevelTwo(op1) == isOpLevelTwo(op2));
    }

    // 정수인지 확인
    public static boolean isInteger(double number) {
        return number == (int) number;
    }

    // 소수점 유효성검사
    public static boolean isValidNumber(String number) {
        try {
            double d = Double.parseDouble(number);
            return true;
        } catch (NumberFormatException nf) {
            throw new NumberFormatException("[ERROR] 수식 오류2: 부적절한 소수점");
        }
    }

}
