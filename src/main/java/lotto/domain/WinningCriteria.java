package lotto.domain;

public enum WinningCriteria {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int matchCount;
    private final int prize;
    private final boolean matchBonus;

    WinningCriteria(int matchCount, int prize, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public static WinningCriteria getWinningType(int matchCount, boolean matchBonus) {
        for (WinningCriteria type : WinningCriteria.values()) {
            if (type.getMatchCount() == matchCount && type.getMatchBonus() == matchBonus) {
                return type;
            }
        }
        return MISS;
    }
}
