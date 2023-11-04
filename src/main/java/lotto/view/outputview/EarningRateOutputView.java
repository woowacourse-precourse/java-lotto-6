package lotto.view.outputview;

import lotto.domain.lottoresult.EarningRate;

public class EarningRateOutputView {
    private static final String EARNING_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public static void printEarningRate(EarningRate earningRate) {
        System.out.printf(EARNING_RATE_FORMAT, earningRate.getRate());
    }
}
