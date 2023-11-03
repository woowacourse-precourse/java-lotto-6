package lotto.domain;

public enum Prize {

    FIRST(6, 0, 2000000000),
    SECOND(5, 1, 30000000),
    THIRD(5, 0, 1500000),
    FOURTH(5, 0, 50000),
    FIFTH(5, 0, 5000),
    NONE(0, 0, 0);

    private final long sameNumberCount;

    private final long sameBonusNumberCount;

    private final int amount;

    Prize(final long sameNumberCount, final long sameBonusNumberCount, final int amount) {
        this.sameNumberCount = sameNumberCount;
        this.sameBonusNumberCount = sameBonusNumberCount;
        this.amount = amount;
    }

    public static Prize of(final Result result) {
        for (Prize prize : values()) {
            if (compare(result, prize)) {
                return prize;
            }
        }
        return NONE;
    }

    private static boolean compare(final Result result, final Prize prize) {
        return result.getSameNumberCount() >= prize.sameNumberCount
                && result.getSameBonusCount() >= prize.sameBonusNumberCount;
    }

    public Money getMoney() {
        return new Money(amount);
    }
}
