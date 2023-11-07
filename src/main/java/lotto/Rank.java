package lotto;

public enum Rank {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    EMPTY(0, 0, false);

    private static final int BONUS_CONTAIN_RANK = 5;
    private final int prize;
    private final int matchCount;
    private final boolean matchBonus;

    public int getPrize() {
        return prize;
    }

    Rank(final int prize, final int matchCount, final boolean matchBonus) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public static Rank getRank(final int matchCount, final boolean matchBonus) {
        if (matchCount == BONUS_CONTAIN_RANK) {
            if (matchBonus) {
                return Rank.SECOND;
            }
            if (!matchBonus) {
                return Rank.THIRD;
            }
        }

        for (Rank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return EMPTY;
    }
}
