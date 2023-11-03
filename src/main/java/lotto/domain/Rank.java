package lotto.domain;

public enum Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000),
    NONE(0, 0);

    private final int countOfMatch;
    private final int prize;
    private final boolean matchBonus;

    Rank(int countOfMatch, int prize) {
        this(countOfMatch, prize, false);
    }

    Rank(int countOfMatch, int prize, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.countOfMatch && matchBonus) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.countOfMatch == countOfMatch && !rank.matchBonus) {
                return rank;
            }
        }

        return NONE;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getPrize() {
        return prize;
    }
}
