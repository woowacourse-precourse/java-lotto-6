package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5,30_000_000),
    THIRD(5,1_500_000),
    FOURTH(4,50_000),
    FIFTH(3,5_000),
    ZERO(0,0)
    ;

    private final int sameNumberCount;
    private final int prizeMoney;

    Rank(int sameNumberCount, int prizeMoney) {
        this.sameNumberCount = sameNumberCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank decideRank(int sameNumberCount, boolean isContainBonusNumber) {
        if(isContainBonusNumber && sameNumberCount == 5) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.sameNumberCount == sameNumberCount && rank != SECOND)
                .findAny()
                .orElse(ZERO);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
