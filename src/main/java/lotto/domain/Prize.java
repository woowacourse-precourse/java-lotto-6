package lotto.domain;

public enum Prize {

    FIRST(6, 0, 2000000000L, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 1, 30000000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 0, 1500000L, "5개 일치 (1,500,000원)"),
    FOURTH(4, 0, 50000L, "4개 일치 (50,000원)"),
    FIFTH(3, 0, 5000L, "3개 일치 (5,000원)"),
    NONE(0, 0, 0L, "그 외 (0원)");

    private final long sameNumberCount;

    private final long sameBonusNumberCount;

    private final Long amount;

    private final String description;

    Prize(final long sameNumberCount, final long sameBonusNumberCount, final Long amount,
            final String description) {
        this.sameNumberCount = sameNumberCount;
        this.sameBonusNumberCount = sameBonusNumberCount;
        this.amount = amount;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public Money getMoney() {
        return new Money(amount);
    }
}
