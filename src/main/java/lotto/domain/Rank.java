package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(1, 6,  2_000_000_000),
    SECOND(2, 5,  30_000_000),
    THIRD(3, 5, 1_500_000),
    FOURTH(4, 4,50_000),
    FIFTH(5, 3, 5_000),
    NOTHING(6, 0, 0);

    private final int rank;
    private final int collectCount;
    private final long prize;
    Rank(int rank, int collectCount, long prize) {
        this.rank = rank;
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

    public int getRank(){
        return rank;
    }

}
