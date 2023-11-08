package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6,  2_000_000_000),
    SECOND(5,  30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4,50_000),
    FIFTH(3, 5_000),
    NOTHING(0, 0);

    private static final int THIRD_COLLECT = 5;

    private final int collectCount;
    private final long prize;

    Rank(int collectCount, long prize) {
        this.collectCount = collectCount;
        this.prize = prize;
    }

    public static Rank decideRank(int collectCount, boolean bonusCheck) {
        if (collectCount == THIRD_COLLECT && !bonusCheck) {
            return Rank.THIRD;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.collectCount == collectCount)
                .findFirst()
                .orElse(NOTHING);
    }

    public long getPrize() {
        return prize;
    }
}
