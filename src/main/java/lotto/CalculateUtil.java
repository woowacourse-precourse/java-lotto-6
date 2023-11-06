package lotto;

public class CalculateUtil {
    private static final int PERCENTAGE_MULTIPLE_VALUE = 100;
    private static final int DEFAULT_POW_VALUE = 10;
    public static double calculatePercentage(double a, double b){
        return a / b * PERCENTAGE_MULTIPLE_VALUE;
    }

    public static double round(double number, int decimalDigit){
        decimalDigit--;
        double digit = Math.pow(DEFAULT_POW_VALUE, decimalDigit);
        return Math.round(number * digit) / digit;
    }
}
