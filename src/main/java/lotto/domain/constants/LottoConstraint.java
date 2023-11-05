package lotto.domain.constants;

import java.util.Objects;

public enum LottoConstraint {
    LOTTO_PICK_COUNT(6),
    UNIT_PRICE(1_000),
    MAXIMUM_PURCHASE_PAYMENT(100_000),

    NUMBER_LOWER_BOUND(1),
    NUMBER_UPPER_BOUND(45);


    private final int value;

    LottoConstraint(int value) {
        this.value = value;
    }

    public boolean isSmaller(int compare) {
        return compare < value;
    }

    public boolean isBigger(int compare) {
        return compare > value;
    }

    public boolean isEqual(int compare) {
        return Objects.equals(compare, value);
    }

    public int getValue() {
        return value;
    }
}
