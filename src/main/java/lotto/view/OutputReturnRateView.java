package lotto.view;

import lotto.domain.ReturnRate;

public class OutputReturnRateView {
    private static final String OUTPUT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printReturnRate(ReturnRate rate) {
        System.out.printf(OUTPUT_MESSAGE, rate.getReturnRate());
    }
}
