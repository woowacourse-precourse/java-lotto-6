package lotto.view;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_PURCHASE_NUMBER = "\n%d개를 구매했습니다.\n";
    private static final String OUTPUT_WINNING_STATISTICS = "\n당첨 통계\n---";
    private static final String OUTPUT_RANK_RESULT = "%s - %d개\n";
    private static final String OUTPUT_TOTAL_RATE_OF_RETURN ="총 수익률은 %.1f%%입니다.\n";


    public void outputPurchaseNumber(int number) {
        System.out.printf(OUTPUT_PURCHASE_NUMBER, number);
    }

    public void outputLottoNumber(List<Integer> list) {
        System.out.println(list);
    }

    public void outputWinningStatistics() {
        System.out.println(OUTPUT_WINNING_STATISTICS);
    }

    public void outputRankResult(String string, int number) {
        System.out.printf(OUTPUT_RANK_RESULT, string, number);
    }

    public void outputTotalRateOfReturn(double number) {
        System.out.printf(OUTPUT_TOTAL_RATE_OF_RETURN, number);
    }
}
