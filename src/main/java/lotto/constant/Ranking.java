package lotto.constant;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    SIXTH(2, 0),
    SEVENTH(1, 0),
    MISS(0, 0);

    private final int matchNumCount;
    private final int reward;

    Ranking(int matchNumCount, int reward) {
        this.matchNumCount = matchNumCount;
        this.reward = reward;
    }

    public static Ranking getRanking(int matchNumCount, boolean isMatchBonusNumber) {
        if (matchNumCount == SECOND.matchNumCount && isMatchBonusNumber) {
            return SECOND;
        }

        if (matchNumCount < MISS.matchNumCount) {
            return MISS;
        }

        return Arrays.stream(values())
                .filter(ranking -> ranking.matchNumCount == matchNumCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_MATCH_RANKING_ERROR.getMessage()));
    }

    public int getReward() {
        return reward;
    }
}
