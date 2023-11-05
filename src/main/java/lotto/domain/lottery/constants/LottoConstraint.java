package lotto.domain.lottery.constants;

public enum LottoConstraint {
    UNIT_PRICE(1_000),
    MAXIMUM_PURCHASE_PAYMENT(100_000),

    LOTTO_PICK_COUNT(6),
    NUMBER_LOWER_BOUND(1),
    NUMBER_UPPER_BOUND(45),

    BONUS_COUNT(1);

    private final int value;

    LottoConstraint(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
