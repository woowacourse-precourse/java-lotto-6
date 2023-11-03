package lotto.domain.constants;

import java.util.Objects;

public enum LottoConstraint {
    LOTTO_PICK_COUNT(6);

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
}
