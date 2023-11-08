package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    NONE(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);
    private static final int MATCH_FIVE = 5;
    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    LottoRank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (isSecondRankCondition(matchCount, matchBonus)) {
            return SECOND;
        }
        return findRankByMatchCount(matchCount);
    }

    private static boolean isSecondRankCondition(int matchCount, boolean matchBonus) {
        return matchCount == MATCH_FIVE && matchBonus;
    }

    private static LottoRank findRankByMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getPrize() {
        return prize;
    }
}
