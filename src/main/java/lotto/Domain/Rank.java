package lotto.Domain;

public enum Rank {
    NOTHING(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchNumberCount;
    private final int prize;

    Rank(int matchNumberCount, int prize) {
        this.matchNumberCount = matchNumberCount;
        this.prize = prize;
    }

    public static Rank valueOf(int matchNumberCount, boolean matchBonusNumber) {
        if (matchNumberCount == SECOND.matchNumberCount && matchBonusNumber) {
            return SECOND;
        }
        for (Rank rank : values()) {
            if (rank != SECOND && rank.matchNumberCount == matchNumberCount) {
                return rank;
            }
        }
        return NOTHING;
    }

    public int getPrize() {
        return this.prize;
    }
}
