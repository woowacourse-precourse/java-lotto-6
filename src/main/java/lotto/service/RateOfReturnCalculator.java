package lotto.service;

public class RateOfReturnCalculator {
    public static double calculateRateOfReturn(int userAmount, int finalPrize) {
        if (userAmount == 0) {
            throw new ArithmeticException();
        }

        double RateOfReturn = (double) finalPrize / userAmount;
        return Math.round(RateOfReturn * 100.0) / 100.0;
    }
}
