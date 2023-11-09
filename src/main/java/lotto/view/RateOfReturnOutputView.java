package lotto.view;

import lotto.dto.RateOfReturn;

public class RateOfReturnOutputView {

    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void outputRateOfReturn(RateOfReturn rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn.show());
    }
}
