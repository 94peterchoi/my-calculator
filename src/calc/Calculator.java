package calc;

public interface Calculator {

    String getInput();

    double calculate(String userFormula);

    void printResult(double result);

}
