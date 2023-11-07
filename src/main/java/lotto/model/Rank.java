package lotto.model;

public enum Rank {
    MISS(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return Rank.FIVE_BONUS;
        }
        if (matchCount == 5) {
            return Rank.FIVE;
        }
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && rank != Rank.FIVE && rank != Rank.FIVE_BONUS) {
                return rank;
            }
        }
        return MISS;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
