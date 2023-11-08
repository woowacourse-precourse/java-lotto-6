package lotto.domain;

import static lotto.configuration.Constants.*;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int matchCount;
    private final int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public static Rank valueOf(int matchCount) {
        for (Rank value : values()) {
            if (matchCount == value.getMatchCount()) {
                return value;
            }
        }
        throw new IllegalArgumentException(Errors.MESSAGE + Errors.BUSINESS_LOGIC);
    }

}
