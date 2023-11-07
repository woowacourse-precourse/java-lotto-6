package lotto.domain;

public enum PrizeTable {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 30_000_000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000);

    private final int matchingNumbers;
    private final int prizeAmount;

    PrizeTable(int matchingNumbers, int prizeAmount) {
        this.matchingNumbers = matchingNumbers;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
