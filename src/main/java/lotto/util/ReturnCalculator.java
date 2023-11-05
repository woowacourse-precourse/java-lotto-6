package lotto.util;

import lotto.domain.WinningStatus;

public class ReturnCalculator {
    public static double calculate(WinningStatus winningStatus, int lottoCount) {
        double returnMoney = winningStatus.getSum();
        int lottoPrice = lottoCount * 1000;
        double rateOfReturn = (returnMoney / lottoPrice) * 100;

        return roundFrom2Digit(rateOfReturn);
    }

    private static double roundFrom2Digit(double rateOfReturn) {
        rateOfReturn *= 10;
        rateOfReturn = Math.round(rateOfReturn);

        return rateOfReturn / 10;
    }
}
