package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int compareCount;
    private final int amount;
    private final boolean bonus;

    Rank(int compareCount, int amount) {
        this(compareCount, amount, false);
    }

    Rank(int compareCount, int amount, boolean bonus) {
        this.compareCount = compareCount;
        this.amount = amount;
        this.bonus = bonus;
    }

    public int getAmount() {
        return amount;
    }

    public static Rank valueOf(int compareCount, boolean bonus) {
        if (compareCount == SECOND.compareCount && bonus) {
            return SECOND;
        }
        for (Rank rank : values()) {
            if (rank.compareCount == compareCount && !rank.bonus) {
                return rank;
            }
        }
        return MISS;
    }
}
