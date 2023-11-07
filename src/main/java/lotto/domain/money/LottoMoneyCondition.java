package lotto.domain.money;

public enum LottoMoneyCondition {

    MONEY_UNIT(1_000),
    MIN_MONEY(1_000),
    MAX_MONEY(1_000_000);

    private final int value;

    LottoMoneyCondition(final int value) {
        this.value = value;
    }

    public static boolean isInvalidValue(final int value) {
        return isNotInRange(value) || canNotDivideByUnit(value);
    }

    private static boolean isNotInRange(final int value) {
        return MIN_MONEY.value > value || MAX_MONEY.value < value;
    }

    private static boolean canNotDivideByUnit(final int value) {
        return value % MONEY_UNIT.value != 0;
    }

    public int value() {
        return value;
    }
}
