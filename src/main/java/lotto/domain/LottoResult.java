package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public record LottoResult(Map<LottoPrizes, Integer> result) {
    private static final String STATISTICS = "당첨 통계";
    private static final String THREE_DASHES = "---";
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
        StringBuilder message = new StringBuilder();
        return message.append(lottoPrizes.getTerm())
                .append(SPACE)
                .append(LEFT_PARENTHESIS)
                .append(lottoPrizes.getParsedWinningAmount())
                .append(RIGHT_PARENTHESIS)
                .append(DASH_WITH_SPACE)
                .append(result.get(lottoPrizes))
                .append(COUNT_TO_KOREAN)
                .toString();
    }

    public int getTotalRevenue() {
        return Arrays.stream(LottoPrizes.values())
                .mapToInt(prize -> prize.getWinningAmount() * result.get(prize))
                .sum();
    }
}
