package lotto.global;

public enum Prize {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000),
    NONE(0);

    private final int amount;

    Prize(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
