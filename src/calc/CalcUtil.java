package calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalcUtil {
    public static final String[] operators = {"+", "-", "*", "/"};
    public static final String[] OpsLevelOne = {"*", "/"};
    public static final String[] OpsLevelTwo = {"+", "-"};


    // 숫자인지 확인
    public static boolean isNumber(String s) {
        if (!s.equals("") && Character.isDigit(s.charAt(0))) {
            return true;
        }
        return false;
    }

    // 연산자인지 확인
    public static boolean isOperator(String operator) {
        if (Arrays.stream(operators).anyMatch(op -> op.equals(operator))) {
            return true;
        }
        return false;
    }

    // 연산자 우선순위1: 곱셈, 나눗셈
    public static boolean isOpLevelOne(String operator) {
        if (Arrays.stream(OpsLevelOne).anyMatch(op -> op.equals(operator))) {
            return true;
        }
        return false;
    }

    // 연산자 우선순위2: 덧셈, 뺄셈
    public static boolean isOpLevelTwo(String operator) {
        if (Arrays.stream(OpsLevelTwo).anyMatch(op -> op.equals(operator))) {
            return true;
        }
        return false;
    }

    // 같은 레벨의 연산자인지 확인
    public static boolean isOpsSameLevel(String op1, String op2) {
        if (isOpLevelOne(op1) == isOpLevelOne(op2))
            return true;
        if (isOpLevelTwo(op1) == isOpLevelTwo(op2))
            return true;

        return false;
    }

    // 정수인지 확인
    public static boolean isInteger(double number) {
        return number == (int) number;
    }

}
