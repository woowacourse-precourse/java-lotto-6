package lotto.util;

import java.util.Map;
import lotto.domain.WinningStatus;

public class ReturnCalculator {
    public static double calculate(Map<WinningStatus, Integer> statusAndCount, int lottoCount) {
        int returnMoney = sumPrice(statusAndCount);
        int lottoPrice = lottoCount * 1000;
        double rateOfReturn = ((double) returnMoney / lottoPrice) * 100;

        return roundFrom2Digit(rateOfReturn);
    }

    private static double roundFrom2Digit(double rateOfReturn) {
        rateOfReturn *= 10;
        rateOfReturn = Math.round(rateOfReturn);

        return rateOfReturn / 10;
    }

    private static int sumPrice(Map<WinningStatus, Integer> statusAndCount) {
        int returnMoney = 0;
        for (WinningStatus status : statusAndCount.keySet()) {
            returnMoney += (statusAndCount.get(status) * status.getPrize());
        }

        return returnMoney;
    }
}
