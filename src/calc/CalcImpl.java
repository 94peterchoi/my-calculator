package calc;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class CalcImpl implements Calculator{

    @Override
    public String getInput() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        System.out.print("수식을 입력하세요: ");

        userInput = scan.nextLine();

        // 중위연산식 유효성 검증
        if (!ExpressionConverter.isValidFormula(userInput.trim().replaceAll(" ", ""))) {
            System.out.println("수식이 잘못됐어요.");
            System.exit(0);
        }

        return userInput;
    }

    @Override
    public double calculate(String userFormula) {
        double solution = 0;
        Stack<Double> numStack = new Stack<>();

        int i = 0;

        // 입력받은 (중위)식을 후위식으로 바꾼다
        ExpressionConverter expressionConverter = new ExpressionConverter();
        List<String> postfix = expressionConverter.toPostfix(userFormula);

        while(i < postfix.size()) {
            String letter = postfix.get(i);
            // 괄호까지 처리할 수 있으면 좋겠지만

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
    public void printResult(double result) {
        if (CalcUtil.isInteger(result)) {
            System.out.println("연산결과는 " + (int)result + "입니다.");
            return;
        }

        double res = Math.floor(result * 1000) / 1000.0;    // 소수점 세자리 아래로 버림
        System.out.println("연산결과는 " + res + " 입니다.");
    }

}
