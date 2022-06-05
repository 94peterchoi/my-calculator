package calc;

import java.util.Scanner;
import java.util.Stack;

public class CalcImpl implements Calculator{

    @Override
    public String getInput() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        System.out.print("수식을 입력하세요: ");

        userInput = scan.nextLine();

        // 올바른 수식인지 검증하는 유효성검사 필요함 (메서드로 따로 빼야겠지)

        return userInput;
    }

    @Override
    public double calculate(String formula) {
        double solution = 0;
        Stack<Double> numStack = new Stack<>();

        int i = 0;

        // 입력받은 (중위)식을 후위식으로 바꾼다
        ExpressionConverter expressionConverter = new ExpressionConverter();
        expressionConverter.toPostfix(formula);

        formula.substring(i, i+1);

        String postfix = "23+78*";
        postfix = "237*+8+";   // 2+3*7+8
        postfix = "23*78/+";   // 2*3 + 7/8===> AB*CD/+

        // ABC*+D+
        while(i < postfix.length()) {

            String letter = postfix.substring(i, i+1);

            // 괄호까지 처리할 수 있으면 좋을텐데

            // 숫자면 푸쉬
            if (CalcUtil.isNumber(letter)) {
                numStack.push(Double.parseDouble(letter));
                i++;
                continue;
            }

            // 참고 - https://velog.io/@srparkgogo/%EB%AC%B8%EC%9E%90%EC%97%B4-%ED%83%80%EC%9E%85%EC%9D%98-%EC%97%B0%EC%82%B0%EC%9E%90%EB%A5%BC-%EC%9D%BC%EB%B0%98-%EC%97%B0%EC%82%B0%EC%9E%90%EB%A1%9C-%EB%B0%94%EA%BE%B8%EC%96%B4-%EA%B3%84%EC%82%B0%ED%95%98%EA%B8%B0
            if (CalcUtil.isOperator(letter)) {
                Operation operation = new Operation();
                numStack.push(operation.operate(numStack, letter));
            } else {    // if에 부정문 걸어서 else를 안쓸 수는 있겠지만...
                System.out.println("잘못된 연산자가 감지되었습니다. 계산기를 종료합니다.");
                System.exit(0);
            }

            i++;
        }

        return numStack.pop();
    }

    @Override
    public void printResult() {
        System.out.println("..");
    }




}
