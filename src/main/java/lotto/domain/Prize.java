package lotto.domain;

public enum Prize {
    FIRST_PLACE(2000000000),
    SECOND_PLACE(30000000),
    THIRD_PLACE(1500000),
    FOURTH_PLACE(50000),
    FIFTH_PLACE(5000),
    NO_PLACE(0);

    private int prizeAmount;

    Prize(int prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
