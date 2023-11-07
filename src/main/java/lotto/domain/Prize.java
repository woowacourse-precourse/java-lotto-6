package lotto.domain;

public enum Prize {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(4, 1500000),
    FOURTH(3, 50000),
    FIFTH(2, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final int reward;

    Prize(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public static Prize valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        for (Prize prize : values()) {
            if (prize.getMatchCount() == matchCount) {
                return prize;
            }
        }
        return NONE;
    }
}
