package lotto.domain;

public enum Ranking {
    FIRST(6, new Money(2000000000), false),
    SECOND(5, new Money(30000000), true),
    THIRD(5, new Money(1500000), false),
    FOURTH(4, new Money(50000), false),
    FIFTH(3, new Money(5000), false),
    NOTHING(0, new Money(0), false);

    private int sameNumberCount;
    private Money prizeMoney;
    private boolean hasBonusNumber;

    Ranking(int sameNumberCount, Money prizeMoney, boolean hasBonusNumber) {
        this.sameNumberCount = sameNumberCount;
        this.prizeMoney = prizeMoney;
        this.hasBonusNumber = hasBonusNumber;
    }
}
