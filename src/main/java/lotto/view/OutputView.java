package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.domain.Lottos;
import lotto.domain.Ranking;
import lotto.domain.WinningStatistics;

public class OutputView {

    private static final String NUMBER_OF_LOTTO_PURCHASED_MESSAGE = "%d개를 구매했습니다.";
    private static final String STATISTICS_FOREWORD_MESSAGE = "당첨통계";
    private static final String DOUBLE_DASH = "--";
    private static final String STATISTICS_WITH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String STATISTICS_MESSAGE = "%d개 일치 (%,d원) - %d개";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private OutputView() {
    }

    private static void printWithFormat(String message, Object... args) {
        System.out.println(String.format(message, args));
    }

    private static void printNumberOfLottoPurchased(int numberOfLottoPurchased) {
        printWithFormat(NUMBER_OF_LOTTO_PURCHASED_MESSAGE, numberOfLottoPurchased);
    }

    public static void printIssuedLottosInformation(Lottos lottos) {
        printNewEmptyLine();

        List<List<Integer>> lottosNumbers = lottos.getLottosNumbers();
        printNumberOfLottoPurchased(lottosNumbers.size());

        for (List<Integer> lottoNumbers : lottosNumbers) {
            System.out.println(lottoNumbers);
        }
        printNewEmptyLine();
    }

    public static void printWinningStatistics(WinningStatistics winningStatistics) {
        printWinningStatisticsMessage();

        Map<Ranking, Integer> statistics = winningStatistics.getStatistics();

        List<Ranking> rankings = new ArrayList<>(List.of(Ranking.values()));
        rankings.remove(Ranking.NOTHING);
        Collections.reverse(rankings);

        for (Ranking ranking : rankings) {
            printWinningStatistics(ranking, statistics.get(ranking));
        }
    }

    private static void printWinningStatistics(Ranking ranking, int count) {
        if (ranking.equals(Ranking.SECOND)) {
            printWithFormat(STATISTICS_WITH_BONUS_MESSAGE, ranking.getMatchNumberCount(),
                ranking.getPrizeMoney(), count);
            return;
        }
        printWithFormat(STATISTICS_MESSAGE, ranking.getMatchNumberCount(),
            ranking.getPrizeMoney(), count);
    }

    private static void printWinningStatisticsMessage() {
        printNewEmptyLine();
        System.out.println(STATISTICS_FOREWORD_MESSAGE);
        System.out.println(DOUBLE_DASH);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        printWithFormat(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }

    public static void printNewEmptyLine() {
        System.out.println();
    }

    public static void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
        printNewEmptyLine();
    }
}
