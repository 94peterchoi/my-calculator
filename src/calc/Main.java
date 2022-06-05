package calc;

public class Main {
    public static void main(String[] args) {

        Calculator calc = new CalcImpl();

        String userFormula = calc.getInput();
        double result = calc.calculate(userFormula);
        calc.printResult(result);

//        formulaChange.toPostfix("11*12*13+14-15/16*17+18/19+223");
//        formulaChange.toPostfix("1/2/3/4");
//        formulaChange.toPostfix("1/2/3/4+5*7");
//        formulaChange.toPostfix("6/3/1*4");


    }
}
