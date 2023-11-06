package lotto;

public class CalculateUtil {
    private static final int PERCENTAGE_MULTIPLE_VALUE = 100;

    public static double calculatePercentage(double a, double b){
        return a / b * PERCENTAGE_MULTIPLE_VALUE;
    }

}
