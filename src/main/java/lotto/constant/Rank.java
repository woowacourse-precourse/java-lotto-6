package lotto.constant;

public enum Rank {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    SIXTH(0, 0);

    private final int amount;
    private final int count;

    Rank(int amount, int count) {
        this.amount = amount;
        this.count = count;
    }

    public static Rank getRank(int count, boolean isBonus) {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.SECOND && !isBonus) {
                continue;
            }
            if (rank.count == count) {
                return rank;
            }
        }
        return Rank.SIXTH;
    }

    public int getAmount() {
        return amount;
    }
}
