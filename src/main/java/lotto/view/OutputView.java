package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.PrizeStatistics;

public class OutputView {

    public static void printLottoPurchaseCount(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public static void printAllLottoNumbers(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public static void printResults(PrizeStatistics prizeStatistics) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Prize.getPrizes()
                .forEach(prize -> printPrizeInfo(prize, prizeStatistics.getCountForPrize(prize)));
    }

    public static void printPrizeInfo(Prize prize, int winningCount) {
        if (prize != Prize.NO_PRIZE) {
            System.out.println(prize.toString() + " - " + winningCount + "개");
        }
    }

    public static void printTotalProfit(Double returnRate) {
        String stringProfit = String.format("%.1f", returnRate);
        System.out.println("총 수익률은 " + stringProfit + "%입니다.");
    }
}
