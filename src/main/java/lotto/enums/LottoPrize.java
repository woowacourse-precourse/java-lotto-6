package lotto.enums;

public enum LottoPrize {
    THREE_MATCH(5000),
    FOUR_MATCH(50000),
    FIVE_MATCH(1500000),
    FIVE_MATCH_BONUS(30000000),
    SIX_MATCH(2000000000),
    NOT_THING_MATCH(0);

    private final int prizeAmount;

    LottoPrize(int prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
