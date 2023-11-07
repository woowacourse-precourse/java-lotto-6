package lotto.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.result.WinningRank;

public class ResultFormatter {
    private static final String CASH_PRIZE_REGEX = "\\B(?=(\\d{3})+(?!\\d))";
    private static final String TOTAL_REWARD_RATE = "총 수익률은 %s%%입니다.";
    private static final String WINNER_SCORE_FORMAT = "%s (%s원) - %d개\n";

    public static String formatResult(Map<WinningRank, Integer> rankResult, BigDecimal resultRate) {
        StringBuilder result = new StringBuilder();
        appendWinningScore(rankResult, result);
        appendResultRate(result, resultRate);
        return result.toString();
    }

    private static void appendWinningScore(Map<WinningRank, Integer> rankResult, StringBuilder result) {
        result.append(Arrays.stream(WinningRank.values())
                .filter(rank -> rank != WinningRank.NONE)
                .sorted(Comparator.reverseOrder())
                .map(rank -> formatWinnerScore(rank, rankResult))
                .collect(Collectors.joining()));
    }

    private static void appendResultRate(StringBuilder result, BigDecimal resultRate) {
        result.append(String.format(TOTAL_REWARD_RATE, resultRate));
    }

    private static String formatWinnerScore(WinningRank rank, Map<WinningRank, Integer> rankResult) {
        String formattedPrize = formatPrize(rank.getPrize());
        int count = rankResult.getOrDefault(rank, 0);
        return String.format(WINNER_SCORE_FORMAT, rank.getDisplay(), formattedPrize, count);
    }

    private static String formatPrize(int prize) {
        return String.valueOf(prize).replaceAll(CASH_PRIZE_REGEX, ",");
    }
}
