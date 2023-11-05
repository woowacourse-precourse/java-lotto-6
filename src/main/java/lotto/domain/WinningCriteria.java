package lotto.domain;

public enum WinningCriteria {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int prize;

    WinningCriteria(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static WinningCriteria getWinningRank(int matchCount, boolean matchBonus) {
        for (WinningCriteria type : WinningCriteria.values()) {
            if (matchCount == 5 && !matchBonus) {
                return THIRD;
            }
            if (type.getMatchCount() == matchCount) {
                return type;
            }
        }
        return MISS;
    }
}
