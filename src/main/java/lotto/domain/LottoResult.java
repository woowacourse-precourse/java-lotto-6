package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public record LottoResult(Map<LottoPrizes, Integer> result) {
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    private static final String SPACE = " ";
    private static final String DASH_WITH_SPACE = " - ";
    private static final String COUNT_TO_KOREAN = "개";
    private static final String NEW_LINE = System.getProperty("line.separator");


    public String getStatistics() {
        return Arrays.stream(LottoPrizes.values())
                .map(this::displayPrizes)
                .collect(Collectors.joining(NEW_LINE));
    }

    private String displayPrizes(LottoPrizes lottoPrizes) {
        final int winCount = result.get(lottoPrizes);
        return lottoPrizes.getTerm()
                + SPACE
                + LEFT_PARENTHESIS
                + lottoPrizes.getParsedWinningAmount()
                + RIGHT_PARENTHESIS
                + DASH_WITH_SPACE
                + winCount
                + COUNT_TO_KOREAN;
    }

    public long getTotalRevenue() {
        return Arrays.stream(LottoPrizes.values())
                .mapToLong(this::getRevenue)
                .sum();
    }

    private long getRevenue(LottoPrizes lottoPrizes) {
        final long winCount = result.get(lottoPrizes);
        final long winAmount = lottoPrizes.getWinningAmount();
        return winCount * winAmount;
    }
}
