package lotto.service;

public class RateOfReturnCalculator {
    public static double calculateRateOfReturn(int amount, int finalPrize) {
        if (amount == 0) {
            throw new ArithmeticException();
        }

        double RateOfReturn = (double) finalPrize / amount * 100;
        return Math.round(RateOfReturn * 10.0) / 10.0;
    }
}