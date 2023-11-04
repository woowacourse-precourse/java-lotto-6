package lotto.constants;

import static lotto.exception.ExceptionMessage.GOAL_NUMBER_SIZE_EXCEPTION;
import static lotto.exception.ExceptionMessage.UNVALID_GOAL_NUMBER;

import java.util.List;

public enum LottoRule {

    MINIMUM_NUMBER(1),
    MAXIMUM_NUMBER(45),
    MINIMUM_MATCH_SIZE(1),
    LOTTO_NUMBER_LENGTH(6);

    private final int value;

    LottoRule(final int value) {
        this.value = value;
    }

    public static void validateNumbersLength(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH.value) {
            throw new IllegalArgumentException(GOAL_NUMBER_SIZE_EXCEPTION.getMessage());
        }
    }

    public static void validateNumberValue(final int number) {
        if (number > MAXIMUM_NUMBER.value || number < MINIMUM_NUMBER.value) {
            throw new IllegalArgumentException(UNVALID_GOAL_NUMBER.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
