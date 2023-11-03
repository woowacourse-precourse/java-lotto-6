package lotto.domain;

import static lotto.constant.Constant.NEW_LINE;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public record LottoResult(Map<LottoPrizes, Integer> result) {
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    private static final String SPACE = " ";
    private static final String DASH_WITH_SPACE = " - ";
    private static final String COUNT_TO_KOREAN = "개";


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

    public BigDecimal getTotalRevenue() {
        return Arrays.stream(LottoPrizes.values())
                .map(this::getRevenue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getRevenue(LottoPrizes lottoPrizes) {
        final BigDecimal winCount = new BigDecimal(result.get(lottoPrizes));
        final BigDecimal winAmount = lottoPrizes.getWinningAmount();
        return winAmount.multiply(winCount);
    }
}
