package calc;

public class Main {
    public static void main(String[] args) {

        Calculator calc = new CalcImpl();

        // 이 3개를 try catch로 감싸고
        String userFormula = calc.getInput();
        double result = calc.calculate(userFormula);
        calc.printResult(result);

        /* 테스트 */
//        formulaChange.toPostfix("11*12*13+14-15/16*17+18/19+223");
//        formulaChange.toPostfix("1/2/3/4");
//        formulaChange.toPostfix("1/2/3/4+5*7");
//        formulaChange.toPostfix("6/3/1*4");


    }
}
