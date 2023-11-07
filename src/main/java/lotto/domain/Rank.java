package lotto.domain;

import lotto.configuration.Constants;

public enum Rank {
    FIRST(6, 1000000000),
    SECOND(5, 300000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private int matchCount;
    private long reward;

    Rank(int matchCount, long reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getReward() {
        return reward;
    }

    public static Rank valueOf(int matchCount) {
        for (Rank value : values()) {
            if (matchCount == value.getMatchCount()) {
                return value;
            }
        }
        throw new IllegalArgumentException(Constants.Error.MESSAGE + Constants.Error.BUSINESS_LOGIC);
    }

}
