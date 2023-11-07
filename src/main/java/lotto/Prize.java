package lotto;

public enum Prize {
    FIRST_PRIZE(2000000000L),
    SECOND_PRIZE(30000000L),
    THIRD_PRIZE(1500000L),
    FOURTH_PRIZE(50000L),
    FIFTH_PRIZE(5000L);

    private final long prizeAmount;

    Prize(long amount) {
        this.prizeAmount = amount;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

}
