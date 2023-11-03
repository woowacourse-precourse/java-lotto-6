package lotto.domain;

public enum Prize {

    FIRST(6, 0, 2000000000L),
    SECOND(5, 1, 30000000L),
    THIRD(5, 0, 1500000L),
    FOURTH(5, 0, 50000L),
    FIFTH(5, 0, 5000L),
    NONE(0, 0, 0L);

    private final long sameNumberCount;

    private final long sameBonusNumberCount;

    private final Long amount;

    Prize(final long sameNumberCount, final long sameBonusNumberCount, final Long amount) {
        this.sameNumberCount = sameNumberCount;
        this.sameBonusNumberCount = sameBonusNumberCount;
        this.amount = amount;
    }

    public static Prize of(final long sameNumberCount, final long sameBonusNumberCount) {
        for (Prize prize : values()) {
            if (compare(sameNumberCount, sameBonusNumberCount, prize)) {
                return prize;
            }
        }
        return NONE;
    }

    private static boolean compare(final long sameNumberCount, final long sameBonusNumberCount,
            final Prize prize) {
        return sameNumberCount >= prize.sameNumberCount
                && sameBonusNumberCount >= prize.sameBonusNumberCount;
    }

    public Integer getGradeInteger() {
        return ordinal() + 1;
    }

    public Money getMoney() {
        return new Money(amount);
    }
}
