// 깃먼저 레포지토리 따고 중간중간 버전 푸시하기


package calc;

import java.util.ArrayList;
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

        // 올바른 수식인지 검증하는 유효성검사 필요함 (메서드로 따로 빼야겠지)

        return userInput;
    }

    @Override
    public double calculate(String formula) {
        double solution = 0;
        List<Integer> numStorage = new ArrayList<>();   // 스택이어야 함
        Stack<Double> numStack = new Stack<>();

        int i = 0;

        // 입력받은 (중위)식을 후위식으로 바꾼다
        formula.substring(i, i+1);

        String postfix = "23+78*";
        postfix = "237*+8+";   // 2+3*7+8
        postfix = "23*78/+";   // 2*3 + 7/8===> AB*CD/+

        // ABC*+D+
        while(i < postfix.length()) {

            String letter = postfix.substring(i,i+1);


            // 계산한다 (2개넘 저장, 연산자, 2개넘 저장, 연산자)
            // 밑에 반복되는 로직을 어떻게 줄일 수 있을지 좀 생각
            // 괄호까지 처리할 수 있으면 좋을텐데

            // 숫자면 푸쉬
            if (CalcUtil.isNumber(letter)) {
                numStack.push(Double.parseDouble(letter));
            }

            // 리팩토링을 이렇게 한 번 해보자
            // 밑에 참고자료 - function microCalculator(n1, n2, operator) {}
            // https://velog.io/@srparkgogo/%EB%AC%B8%EC%9E%90%EC%97%B4-%ED%83%80%EC%9E%85%EC%9D%98-%EC%97%B0%EC%82%B0%EC%9E%90%EB%A5%BC-%EC%9D%BC%EB%B0%98-%EC%97%B0%EC%82%B0%EC%9E%90%EB%A1%9C-%EB%B0%94%EA%BE%B8%EC%96%B4-%EA%B3%84%EC%82%B0%ED%95%98%EA%B8%B0

            // 연산자면 pop
            if ("+".equals(letter)) {
                double secondNum = numStack.pop();
                double firstNum = numStack.pop();
                double operationResult = (double)firstNum + secondNum;
                numStack.push(operationResult);
                solution = operationResult;
            }

            if ("-".equals(letter)) {
                double secondNum = numStack.pop();
                double firstNum = numStack.pop();
                double operationResult = (double)firstNum - secondNum;
                numStack.push(operationResult);
                solution = operationResult;
            }


            if ("*".equals(letter)) {
                double secondNum = numStack.pop();
                double firstNum = numStack.pop();
                double operationResult = (double)firstNum * secondNum;
                numStack.push(operationResult);
                solution = operationResult;
            }


            if ("/".equals(letter)) {
                double secondNum = numStack.pop();
                double firstNum = numStack.pop();
                double operationResult = (double)firstNum / secondNum;
                numStack.push(operationResult);
                solution = operationResult;
            }

            i++;

        }

        return solution;
    }

    @Override
    public void printResult() {
        System.out.println("..");
    }

}
