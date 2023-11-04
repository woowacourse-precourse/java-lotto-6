package lotto.domain;

import java.util.Map;

public class ReturnCalculator {
    public static double calculate(Map<WinningStatus, Integer> statusAndCount, int lottoCount) {
        int returnMoney = sumPrice(statusAndCount);
        int lottoPrice = lottoCount * 1000;

        return ((double) returnMoney / lottoPrice) * 100;
    }

    private static int sumPrice(Map<WinningStatus, Integer> statusAndCount) {
        int returnMoney = 0;
        for (WinningStatus status : statusAndCount.keySet()) {
            returnMoney += (statusAndCount.get(status) * status.getPrice());
        }

        return returnMoney;
    }
}
