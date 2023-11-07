package lotto;

public class Calculator {
    public double calculateRate(int val1, int val2){
        double result = (double) val1 / val2 * 100;
        double roundedResult = Math.round(result * 100.0) / 100.0;
        return roundedResult;
    }
}
