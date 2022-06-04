package calc;

import java.util.Arrays;
import java.util.List;

public class CalcUtil {
    public static final String[] operators = {"+", "-", "*", "/"};
    public static final String[] OpsLevelOne = {"*", "/"};
    public static final String[] OpsLevelTwo = {"+", "-"};

    // 숫자
    public static boolean isNumber(String s) {
        if (Character.isDigit(s.charAt(0))) {
            return true;
        }
        return false;
    }

    // 연산자
    public static boolean isOperator(String operator) {
        if (Arrays.stream(operators).anyMatch(op -> op.equals(operator))) {
            return true;
        }
        return false;
    }

    // 우선순위1: 곱셈, 나눗셈
    public static boolean isOpLevelOne(String operator) {
        if (Arrays.stream(OpsLevelOne).anyMatch(op -> op.equals(operator))) {
            return true;
        }
        return false;
    }

    // 우선순위2: 덧셈, 뺄셈
    public static boolean isOpLevelTwo(String operator) {
        if (Arrays.stream(OpsLevelTwo).anyMatch(op -> op.equals(operator))) {
            return true;
        }
        return false;
    }

}
