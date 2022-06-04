package calc;

public class Main {
    public static void main(String[] args) {

//        Calculator calc = new CalcImpl();
//
//        String input = calc.getInput();
//
//        double result = calc.calculate(input);
//
//        System.out.print(result);

        FormulaChange formulaChange = new FormulaChange();
        formulaChange.toPostfix("2*3+4*5");


    }
}
