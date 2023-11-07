package lotto.domain.Enum;

public enum Rank {
    FIRST(6, 200000000),
    SECOND(6, 30000000),
    THIRD(5, 1500000),
    FORTH(4, 50000),
    FIFTH(3, 5000);
    private int count;
    private int amount;

    Rank(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }
}
