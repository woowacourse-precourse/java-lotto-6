package lotto.domain.view.printer;

import java.util.Map;
import lotto.domain.config.ScoreConfig;
import lotto.domain.entity.Order;
import lotto.domain.entity.Statistics;

public class LottoStatisticsPrinter {
    private static final String WINNING_STATISTICS_PRINT_MESSAGE = "당첨 통계";
    private static final String BASE_LINE = "---";
    private static final String WINNING_POINT_PRINT_MESSAGE = "%d개 일치%s (%s원) - %d개";
    private static final String BONUS_SUFFIX = ", 보너스 볼 일치";
    private static final String NULL_SUFFIX = "";
    private static final String RATE_OF_RETURN_PRINT_MESSAGE = "총 수익률은 %.2f%%입니다.";

    public static void printStatistics(Order order) {
        System.out.println(WINNING_STATISTICS_PRINT_MESSAGE);
        System.out.println(BASE_LINE);

        Statistics statistics = order.getStatistics();
        Map<ScoreConfig, Integer> winningInfo = statistics.getWinning();
        winningInfo.forEach((key, value) -> {
            printWinningPoint(key, value);
        });
    }

    private static void printWinningPoint(ScoreConfig score, Integer winningNumber) {
        String suffix = NULL_SUFFIX;
        int matchCount = score.getMatchCount();
        String reward = score.getFormattedReward().getThousandsSeparator();
        if (score.isBonusMatch()) {
            suffix = BONUS_SUFFIX;
        }
        System.out.printf(WINNING_POINT_PRINT_MESSAGE, matchCount, suffix, reward, winningNumber);
    }

    public static void printRateOfReturn(Order order) {
        System.out.printf(RATE_OF_RETURN_PRINT_MESSAGE, order.getRateOfReturn());
    }
}
