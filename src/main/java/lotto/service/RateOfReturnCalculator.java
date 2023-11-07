package lotto.service;

public class RateOfReturnCalculator {
    public static double calculateRateOfReturn(int userAmount, int finalPrize) {
        if (userAmount == 0) {
            throw new ArithmeticException();
        }

        double RateOfReturn = (double) finalPrize / userAmount * 100;
        return Math.round(RateOfReturn * 10.0) / 10.0;
    }
}
