package lotto.View.OutputView;

import static lotto.View.SystemMessage.RESULT_RATE_RETURN;

public class PrintRateReturn {

    public static void printRateReturn(double rateReturn) {
        getPrintRateReturn(rateReturn);
    }

    private static void getPrintRateReturn(double rateReturn) {
        System.out.printf(RESULT_RATE_RETURN.getMessage(), rateReturn);
    }
}
