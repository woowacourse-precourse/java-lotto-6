package lotto.view;

import static lotto.message.Message.*;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningStatistics;

public class Output {
    public static void printWinningStatisticsMessage() {
        System.out.println("\n" + WINNING_STATISTICS.message());
        System.out.print(SEPARATOR.message());
    }

    public static void printPurchaseAmountMessage() {
        System.out.println(PURCHASE_AMOUNT.message());
    }

    public static void printPurchaseLottoQuantityMessage(int lottoQuantity) {
        System.out.println("\n" + lottoQuantity + "개를 구매했습니다.");
    }

    public static void printWinningNumberMessage() {
        System.out.println("\n" + WINNING_NUMBER.message());
    }

    public static void printBonusNumberMessage() {
        System.out.println("\n" + BONUS_NUMBER.message());
    }

    public static void printProfitPercentage(String profitPercentage) {
        System.out.println("총 수익률은 " + profitPercentage + "%입니다.");
    }

    public static void printTotalLotto(List<Lotto> totalLotto) {
        totalLotto.stream().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void printWinningResult(WinningStatistics winningStatistics) {
        Map<Ranking, Integer> winningResult = winningStatistics.getWinningStatus();
        StringBuilder stringBuilder = new StringBuilder("\n");

        for (Ranking ranking : winningStatistics.getWinningStatus().keySet()) {
            stringBuilder.append(ranking.getWinningMessage() + winningResult.get(ranking) + "개").append("\n");
        }

        System.out.print(stringBuilder);
    }
}
