package lotto;

public enum Prize {
    MATCH3(5000),
    MATCH4(50000),
    MATCH5(1500000),
    MATCH5_WITH_BONUS(30000000),
    MATCH6(2000000000);

    private final int amount;

    Prize(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}