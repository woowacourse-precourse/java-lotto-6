package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6,  2_000_000_000),
    SECOND(5,  30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4,50_000),
    FIFTH(3, 5_000),
    NOTHING(0, 0);

    private final int collectCount;
    private final long prize;
    Rank(int collectCount, long prize) {
        this.collectCount = collectCount;
        this.prize = prize;
    }

    public static Rank decideRank(int count, boolean isBonus) {
        if (isBonus && count == 5) {
            return Rank.SECOND;
        }

        return Arrays.stream(values())
                .filter(value -> value != Rank.SECOND)
                .filter(value -> value.collectCount == count)
                .findFirst()
                .orElse(NOTHING);
    }

    public long getPrize() {
        return prize;
    }

    public int getCollectCount(){
        return collectCount;
    }

}
