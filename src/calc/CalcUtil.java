package calc;

import java.util.List;

public class CalcUtil {
    public static final String[] operators = {"+", "-", "*", "/"};
    public static final String[] OpsLevelOne = {"*", "/"};
    public static final String[] OpsLevelTwo = {"+", "-"};

    public static boolean isNumber(String s) {
        if (Character.isDigit(s.charAt(0))) {
            return true;
        }
        return false;
    }

    public static boolean isOperator(String operator) {
        if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
            return true;
        }
        return false;
    }

}
