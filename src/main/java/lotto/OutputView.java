package lotto;

import lotto.domain.common.Money;
import lotto.domain.lotto.LottoPrize;

import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.List;

class OutputView {

    private static final String PRINT_ISSUANCE_RESULT_SIZE_FORMAT = "%n%d개를 구매했습니다.%n";
    private static final String PRINT_EACH_PRIZE_RESULT_FORMAT = "%s (%s) - %d개%n";
    private static final String PRINT_EARNING_RATE_FORMAT = "총 수익률은 %s%%입니다.";
    private static final String PRINT_STATISTICS_HEADER = "당첨 통계";
    private static final String PRINT_STATISTICS_HEADER_DIVIDER = "---";

    public static void printIssuanceResult(List<List<Integer>> issuanceResult) {
        printIssuanceResultSize(issuanceResult);
        printIssuanceResultAll(issuanceResult);
        printPadding();
    }

    private static void printIssuanceResultSize(List<List<Integer>> issuanceResult) {
        System.out.format(PRINT_ISSUANCE_RESULT_SIZE_FORMAT, issuanceResult.size());
    }

    private static void printIssuanceResultAll(List<List<Integer>> issuanceResult) {
        issuanceResult.forEach(System.out::println);
    }

    private static void printPadding() {
        System.out.println();
    }

    public static void printStatistics(EnumMap<LottoPrize, Integer> statistics) {
        printPadding();
        printStatisticsHeader();
        printPrizeResultAll(statistics);
    }

    private static void printStatisticsHeader() {
        System.out.println(PRINT_STATISTICS_HEADER);
        System.out.println(PRINT_STATISTICS_HEADER_DIVIDER);
    }

    private static void printPrizeResultAll(EnumMap<LottoPrize, Integer> statistics) {
        statistics.forEach(OutputView::printPrizeResultEach);
    }

    private static void printPrizeResultEach(LottoPrize prize, Integer count) {
        if (prize.isWin()) {
            System.out.format(
                    PRINT_EACH_PRIZE_RESULT_FORMAT,
                    prize.getRuleDescription(),
                    buildRewardMessage(prize.getReward()),
                    count
            );
        }
    }

    private static String buildRewardMessage(int reward) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();

        return numberFormat.format(reward) + Money.CURRENCY;
    }

    public static void printEarningRate(double earningRate) {
        System.out.format(PRINT_EARNING_RATE_FORMAT, earningRate);
    }
}
