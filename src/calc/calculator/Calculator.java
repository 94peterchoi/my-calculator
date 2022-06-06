package calc.calculator;

public interface Calculator {

    String getInput();

    double calculate(String userInput) throws Exception;

    void printResult(double result);

}
