package lotto.domain;

import java.util.Arrays;

public enum Rank {

    ZERO(0,0, " "),
    FIFTH(3,5_000, "3개 일치 (5,000원) - "),
    FOURTH(4,50_000, "4개 일치 (50,000원) - "),
    THIRD(5,1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5,30_000_000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ")
    ;

    private final int sameNumberCount;
    private final int prizeMoney;
    private final String message;

    Rank(int sameNumberCount, int prizeMoney, String message) {
        this.sameNumberCount = sameNumberCount;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public static Rank decideRank(int sameNumberCount, boolean isContainBonusNumber) {
        if (isContainBonusNumber && sameNumberCount == 5) {
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

    public String getMessage() {
        return message;
    }
}
