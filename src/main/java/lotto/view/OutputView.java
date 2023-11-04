package lotto.view;

public class OutputView {
    private static final String PURCAHSE_AMOUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_STATS_HEADER = "당첨 통계";
    private static final String DASH_LINE = "---";

    private static final String TOTAL_RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printPurchaseAmount(int purchaseAmount){
        System.out.printf(PURCAHSE_AMOUNT_FORMAT,purchaseAmount);
    }

    public void printTotalRateOfReturn(double rateOfReturn){
        System.out.printf(TOTAL_RATE_OF_RETURN_FORMAT,rateOfReturn);
    }
}
