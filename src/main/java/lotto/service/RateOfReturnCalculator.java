package lotto.service;

public class RateOfReturnCalculator {

    private final static String IS_AMOUNT_ZERO_EXCEPTION_MESSAGE = "[ERROR] 구입금액이 올바른 값이 아닙니다.";

    public static double calculateRateOfReturn(int amount, int finalPrize) {
        if (amount == 0) {
            throw new ArithmeticException(IS_AMOUNT_ZERO_EXCEPTION_MESSAGE);
        }

        double RateOfReturn = (double) finalPrize / amount * 100;
        return Math.round(RateOfReturn * 10.0) / 10.0;
    }
}