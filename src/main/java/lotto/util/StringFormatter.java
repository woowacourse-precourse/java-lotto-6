package lotto.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.WinningRank;

public class StringFormatter {
    public enum Format {
        REWARD_RATE_FORMAT("#,##0.0"),
        STATISTICS_RESULT_FORMAT("%s (%,d원) - %d개\n");

        private final String format;

        Format(String format) {
            this.format = format;
        }

        public String toString() {
            return this.format;
        }
    }

    public static String mapToWinningStatisticsToString(Map<WinningRank, Integer> winningStatistics) {
        StringBuilder result = new StringBuilder();
        addStatistics(winningStatistics, result);
        return result.toString();
    }

    private static void addStatistics(Map<WinningRank, Integer> winningStatistics, StringBuilder result) {
        List<WinningRank> winningResults = getBasicWinningResults();
        for (WinningRank winningResult : winningResults) {
            result.append(
                    String.format(Format.STATISTICS_RESULT_FORMAT.toString(),
                            winningResult.getMessage(),
                            winningResult.getPrize(),
                            winningStatistics.getOrDefault(winningResult, 0)));
        }
    }

    private static List<WinningRank> getBasicWinningResults() {
        return Arrays.stream(WinningRank.values())
                .filter(rank -> rank != WinningRank.NOTHING)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public static String mapRewardRateToString(BigDecimal rewardDate) {
        return new DecimalFormat(Format.REWARD_RATE_FORMAT.format).format(rewardDate);
    }
}