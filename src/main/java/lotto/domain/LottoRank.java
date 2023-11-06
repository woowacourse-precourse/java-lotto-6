package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    DEFAULT(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank findRank(int matchCount) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findAny()
                .orElse(DEFAULT);
    }

    public double multiple(int count) {
        return prize * count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
