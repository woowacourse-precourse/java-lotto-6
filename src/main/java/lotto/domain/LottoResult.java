package lotto.domain;

import static lotto.domain.constant.DomainConstant.NEW_LINE;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.money.Money;

public record LottoResult(Map<LottoPrizes, Long> result) {
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
        final long winCount = result.get(lottoPrizes);
        return lottoPrizes.getTerm()
                + SPACE
                + LEFT_PARENTHESIS
                + lottoPrizes.winningAmountToString()
                + RIGHT_PARENTHESIS
                + DASH_WITH_SPACE
                + winCount
                + COUNT_TO_KOREAN;
    }

    public Money getTotalRevenue() {
        return Arrays.stream(LottoPrizes.values())
                .map(this::getRevenue)
                .reduce(Money.ZERO, Money::sum);
    }

    private Money getRevenue(LottoPrizes lottoPrizes) {
        final long winCount = result.get(lottoPrizes);
        final Money winAmount = lottoPrizes.getWinningAmount();
        return winAmount.multiplyByCount(winCount);
    }
}
