package lotto.view;

import lotto.model.Lotto;
import lotto.model.WinningPrize;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PurchaseLottosCountPrintFormat = "%d개를 구매했습니다.\n";
    private static final String WinningStatisticsPrintMessage = "당첨 통계\n---";
    private static final String WinningResultPrintFormat = "%d개 일치 (%s원) - %d개\n";
    private static final String RateOfReturnPrintFormat = "총 수익률은 %.1f%%입니다.\n";

    public void showEmptyLine(){
        System.out.println();
    }

    public void showPurchaseLottos(int purchaseLottosCount, List<Lotto> purchaseLottos) {
        System.out.printf(PurchaseLottosCountPrintFormat, purchaseLottosCount);
        for (Lotto purchaseLotto : purchaseLottos) {
            System.out.println(purchaseLotto.getNumbers());
        }
    }

    public void showWinningStatistics(Map<WinningPrize, Integer> winningResult, double rateOfReturn) {
        showWinningStatisticsMessage();
        showResult(winningResult);
        showRateOfReturn(rateOfReturn);
    }

    private void showWinningStatisticsMessage() {
        System.out.println(WinningStatisticsPrintMessage);
    }

    private void showResult(Map<WinningPrize, Integer> winningResult) {
        for (Map.Entry<WinningPrize, Integer> entry : winningResult.entrySet()) {
            WinningPrize winningPrize = entry.getKey();
            int count = entry.getValue();
            String reward = NumberFormat.getInstance().format(winningPrize.getReward());
            System.out.printf(WinningResultPrintFormat, winningPrize.getMatchCount(), reward, count);
        }
    }

    private void showRateOfReturn(double rateOfReturn) {
        System.out.printf(RateOfReturnPrintFormat, rateOfReturn);
    }
}
