package lotto;

public enum Prize {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_MATCH_BONUS(5, 30000000),
    SIX_MATCH(6, 2000000000),
    ZERO_MATCH(2,0 );

    private final int matchingNumbers;
    private final int amount;

    Prize(int matchingNumbers, int amount) {
        this.matchingNumbers = matchingNumbers;
        this.amount = amount;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getAmount() {
        return amount;
    }
}
