package lotto.domain;

import java.util.Arrays;

public enum Ranking {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    FAIL(-1, 0);

    private int matchCount;
    private int reward;

    Ranking(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Ranking getRanking(int matchCount, boolean containBonusBall) {
        if(matchCount == THIRD.matchCount && !containBonusBall) {
            return THIRD;
        }

        if(matchCount < FIFTH.matchCount) {
            return FAIL;
        }

        return Arrays.stream(values())
                .filter(ranking -> ranking.getMatchCount() == matchCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
