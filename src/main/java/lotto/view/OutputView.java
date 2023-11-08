package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.PrizeStatistics;

public class OutputView {

    private static final String NEWLINE = "\n";
    private static final String LOTTO_COUNT_UNIT = "개";
    private static final String BUY_COMPLETE_MESSAGE = LOTTO_COUNT_UNIT + "를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = NEWLINE + "당첨 통계" + NEWLINE + "---";
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottoPurchaseCount(int count) {
        System.out.println(NEWLINE + count + BUY_COMPLETE_MESSAGE);
    }

    public static void printAllLottoNumbers(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public static void printResults(PrizeStatistics prizeStatistics) {
        System.out.println(WINNING_STATISTICS_MESSAGE);

        Prize.getPrizes()
                .forEach(prize -> printPrizeInfo(prize, prizeStatistics.getCountForPrize(prize)));
    }

    public static void printPrizeInfo(Prize prize, int winningCount) {
        if (prize != Prize.NO_PRIZE) {
            System.out.println(prize.toString() + " - " + winningCount + LOTTO_COUNT_UNIT);
        }
    }

    public static void printTotalProfit(Double rateOfReturn) {
        System.out.println(String.format(TOTAL_PROFIT_MESSAGE, rateOfReturn));
    }
}
