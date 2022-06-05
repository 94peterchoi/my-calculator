package calc;

public interface Calculator {

    String getInput();

    double calculate(String userFormula) throws Exception;

    void printResult(double result);

}
