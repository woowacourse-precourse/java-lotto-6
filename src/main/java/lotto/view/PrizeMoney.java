package lotto.view;

public enum PrizeMoney {

    THREE(5_000),
    FOUR(50_000),
    FIVE(1_500_000),
    FIVE_AND_BONUS(30_000_000),
    SIX(2_000_000_000);

    private final int prizeMoneyValue;

    PrizeMoney(int prizeMoneyValue) {
        this.prizeMoneyValue = prizeMoneyValue;
    }

    public int getPrizeMoneyValue() {
        return prizeMoneyValue;
    }
}
