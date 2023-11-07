package lotto;

public enum Prize {
    FIFTH(5_000),
    FOURTH(50_000),
    THIRD(1_500_000),
    SECOND(30_000_000),
    FIRST(2_000_000_000);

    private final int prizeAmount;

    Prize(int prizeAmount) {

        this.prizeAmount = prizeAmount;
    }

    public int getPrizeAmount() {

        return prizeAmount;
    }
}
