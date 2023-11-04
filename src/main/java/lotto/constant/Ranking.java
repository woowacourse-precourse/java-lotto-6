package lotto.constant;

import java.util.Arrays;

public enum Ranking {

    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean isMatchBonus;
    private final int prize;

    Ranking(int matchCount, boolean isMatchBonus, int prize) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
        this.prize = prize;
    }

    public static Ranking getRanking(int matchCount, boolean isMatchBonus) {
        return Arrays.stream(Ranking.values())
                .filter(value -> value.matchCount == matchCount)
                .filter(value -> value.isMatchBonus == isMatchBonus)
                .findAny()
                .orElse(Ranking.NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isSecond() {
        return this == Ranking.SECOND;
    }
}
