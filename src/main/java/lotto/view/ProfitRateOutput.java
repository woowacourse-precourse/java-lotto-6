package lotto.view;

public class ProfitRateOutput {

    private static final String TOTAL_PROFIT_RATE = "총 수익률은 %s%%입니다.";

    public static void profitRate(double profitRate) {
        System.out.printf(TOTAL_PROFIT_RATE, profitRate);
    }
}
