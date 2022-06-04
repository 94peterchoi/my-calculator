package calc;

public class CalcUtil {

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
