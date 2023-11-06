package lotto.utility;

public enum PrizeUnit {
    THREE_MATCH(5000),
    FOUR_MATCH(50000),
    FIVE_MATCH(1500000),
    BONUS_MATCH(30000000),
    SIX_MATCH(2000000000);

    private final int prizeAmount;

    PrizeUnit(int prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public int getPrizeUnitAmount() {
        return prizeAmount;
    }
}
