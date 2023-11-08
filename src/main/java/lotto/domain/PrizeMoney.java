package lotto.domain;

public enum PrizeMoney {
    ZERO(0), ONE(0), TWO(0), THREE(5_000), FOUR(50_000), FIVE(1_500_000), SIX(2_000_000_000), FIVE_AND_BONUS(
            30_000_000);

    private final int prizeMoneyValue;

    PrizeMoney(int prizeMoneyValue) {
        this.prizeMoneyValue = prizeMoneyValue;
    }

    public static PrizeMoney getByOrdinal(int ordinal) {
        for (PrizeMoney prize : values()) {
            if (prize.ordinal() == ordinal) {
                return prize;
            }
        }
        throw new IllegalArgumentException("[ERROR]" + ordinal);
    }

    public int getPrizeMoneyValue() {
        return prizeMoneyValue;
    }

}
