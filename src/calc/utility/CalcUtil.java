package calc.utility;

import java.util.Arrays;

public class CalcUtil {
    public static final String[] OPERATORS = {"+", "-", "*", "/"};
    public static final String[] OPS_LEVEL_ONE = {"*", "/"};
    public static final String[] OPS_LEVEL_TWO = {"+", "-"};

    // 숫자인지 확인 (하나의 문자열만 처리할 수 있음)
    public static boolean isNumber(String s) {
        return !s.equals("") && isRealNumber(s.charAt(0));
    }

    // 실수 요소 확인 (숫자 or 소수점)
    private static boolean isRealNumber(Character ch) {
        return Character.isDigit(ch) || '.' == ch;
    }

    // 연산자인지 확인
    public static boolean isOperator(String operator) {
        return Arrays.asList(OPERATORS).contains(operator);
    }

    // 연산자 우선순위1: 곱셈, 나눗셈
    public static boolean isOpLevelOne(String operator) {
        return Arrays.asList(OPS_LEVEL_ONE).contains(operator);
    }

    // 연산자 우선순위2: 덧셈, 뺄셈
    public static boolean isOpLevelTwo(String operator) {
        return Arrays.asList(OPS_LEVEL_TWO).contains(operator);
    }

    // 같은 레벨의 연산자인지 확인
    public static boolean isOpsSameLevel(String op1, String op2) {
        return (isOpLevelOne(op1) == isOpLevelOne(op2)) || (isOpLevelTwo(op1) == isOpLevelTwo(op2));
    }

    // 정수인지 확인
    public static boolean isInteger(double number) {
        return number == (int) number;
    }

    // 소수 유효성검사
    public static boolean isValidNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException nf) {
            throw new NumberFormatException("[ERROR] 수식 오류2: 부적절한 소수점");
        }
    }

}
