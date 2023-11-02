package lotto.util;

import lotto.domain.Constant;

public class Util {
    public static int calculateAttempt(int cash) {
        int attempt = cash / Constant.CASH_UNIT.getValue();
        return attempt;
    }

    public static double calculateRateOfReturn(int cash, int returnCash) {
        return 0;
    }
}
