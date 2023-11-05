package lotto.domain;

import lotto.constant.ErrorMessage;

public final class BonusNumber {

    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;
    private final Integer value;

    public BonusNumber(final Integer value) {
        validate(value);
        this.value = value;
    }

    private void validate(final Integer value) {
        if (MIN_BONUS_NUMBER > value || MAX_BONUS_NUMBER < value) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.toValue());
        }
    }
}
