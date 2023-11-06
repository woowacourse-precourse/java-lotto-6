package lotto.view;

import lotto.model.Lotto;
import lotto.model.WinningPrize;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String bonusNumberMatch = ", 보너스 볼 일치 ";
    private static final String purchaseLottosCountPrintFormat = "%d개를 구매했습니다.\n";
    private static final String winningStatisticsPrintMessage = "당첨 통계\n---";
    private static final String winningResultPrintFormat = "%d개 일치%s(%s원) - %d개\n";
    private static final String rateOfReturnPrintFormat = "총 수익률은 %.1f%%입니다.\n";

    public static void showEmptyLine(){
        System.out.println();
    }

    public static void showPurchaseLottos(int purchaseLottosCount, List<Lotto> purchaseLottos) {
        System.out.printf(purchaseLottosCountPrintFormat, purchaseLottosCount);
        for (Lotto purchaseLotto : purchaseLottos) {
            System.out.println(purchaseLotto.getNumbers());
        }
    }

    public static void showWinningStatistics(Map<WinningPrize, Integer> winningResult, double rateOfReturn) {
        showWinningStatisticsMessage();
        showResult(winningResult);
        showRateOfReturn(rateOfReturn);
    }

    private static void showWinningStatisticsMessage() {
        System.out.println(winningStatisticsPrintMessage);
    }

    private static void showResult(Map<WinningPrize, Integer> winningResult) {
        for (Map.Entry<WinningPrize, Integer> entry : winningResult.entrySet()) {
            WinningPrize winningPrize = entry.getKey();
            int count = entry.getValue();
            String bonusFormat = " ";
            if(winningPrize== WinningPrize.SECOND_PRIZE){
                bonusFormat = bonusNumberMatch;
            }
            String reward = NumberFormat.getInstance().format(winningPrize.getReward());
            System.out.printf(winningResultPrintFormat, winningPrize.getMatchCount(), bonusFormat, reward, count);
        }
    }

    private static void showRateOfReturn(double rateOfReturn) {
        System.out.printf(rateOfReturnPrintFormat, rateOfReturn);
    }
}
