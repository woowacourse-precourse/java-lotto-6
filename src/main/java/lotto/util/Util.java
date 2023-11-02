package lotto.util;

import lotto.domain.LottoConstant;

public class Util {
    public static int calculateAttempt(int cash) {
        int attempt = cash / LottoConstant.CASH_UNIT.getValue();
        return attempt;
    }

    public static double calculateRateOfReturn(int cash, int returnCash) {
        return 0;
    }
}
