package lotto.domain.result;

import java.util.Arrays;

public enum LottoPrize {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_MATCH_WITH_BONUS(7, 30_000_000),
    SIX_MATCH(6, 2_000_000_000);

    private final int numberOfMatches;
    private final int prizeAmount;

    LottoPrize(int numberOfMatches, int prizeAmount) {
        this.numberOfMatches = numberOfMatches;
        this.prizeAmount = prizeAmount;
    }

    public static LottoPrize findByNumberOfMatches(int numberOfMatches) {
        return Arrays.stream(values())
            .filter(prize -> prize.getNumberOfMatches() == numberOfMatches)
            .findFirst().get();
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}