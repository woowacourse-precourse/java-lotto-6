package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, new Money(2000000000), false),
    SECOND(5, new Money(30000000), true),
    THIRD(5, new Money(1500000), false),
    FOURTH(4, new Money(50000), false),
    FIFTH(3, new Money(5000), false),
    NOTHING(0, new Money(0), false);

    private int matchNumberCount;
    private Money prizeMoney;
    private boolean hasBonusNumber;

    Ranking(int matchNumberCount, Money prizeMoney, boolean hasBonusNumber) {
        this.matchNumberCount = matchNumberCount;
        this.prizeMoney = prizeMoney;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Ranking of(long sameNumberCount, boolean hasBonusNumber) {
        return Arrays.stream(Ranking.values())
            .filter(ranking -> ranking.isSameMatchNumberCount(sameNumberCount))
            .filter(ranking -> ranking.isSameBonusNumber(hasBonusNumber))
            .findFirst()
            .orElse(NOTHING);
    }

    private boolean isSameBonusNumber(boolean hasBonusNumber) {
        return this.hasBonusNumber == hasBonusNumber;
    }

    private boolean isSameMatchNumberCount(long matchNumberCount) {
        return this.matchNumberCount == matchNumberCount;
    }

    public long getPrizeMoney() {
        return prizeMoney.getMoney();
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }
}
