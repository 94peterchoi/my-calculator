package calc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FormulaChange {
    // 중위연산 -> 후위연산
    // 에러처리 필수
    Queue<Double> numbers = new LinkedList<>();
    Queue<String> operators = new LinkedList<>();
    List<String> postfix = new ArrayList<>();

    public List<String> toPostfix(String formula) {

        int i = 0;

        // 연산자랑 한자리 숫자는 괜찮은데 숫자가 2자리 이상일 때 처리로직 필요함
        while(i < formula.length()) {
            String letter = formula.substring(i, i+1);
            if (CalcUtil.isNumber(letter)) {
                numbers.add(Double.parseDouble(letter));
            }

            if (CalcUtil.isOperator(letter)) {
                operators.add(letter);
            }

            i++;
        }

        return joinToPostfix();
    }

    // 후위연산식으로 결합
    private List<String> joinToPostfix() {
        while(true) {
            // 말도 안 됨 ..
            Double num1 = numbers.remove();
            Double num2 = numbers.remove();
            String op = operators.remove();

            postfix.add(num1.toString());
            postfix.add(num2.toString());
            postfix.add(op);

            if (numbers.isEmpty() && operators.isEmpty()) {
                break;
            }
        }
        return postfix;
    }


}
