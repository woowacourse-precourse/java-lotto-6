package lotto.model;

import static lotto.view.exception.InputException.GOAL_NUMBER_SIZE_EXCEPTION;
import static lotto.view.exception.InputException.UNVALID_GOAL_NUMBER;

import java.util.List;

public enum LottoConstant {

    MINIMUM_NUMBER(1),
    MAXIMUM_NUMBER(45),
    LOTTO_NUMBERS_SIZE(6),
    FIRST_PRIZE_MATCH(6),
    SECOND_PRIZE_MATCH(5),
    THIRD_PRIZE_MATCH(5),
    FOURTH_PRIZE_MATCH(4),
    FIFTH_PRIZE_MATCH(3);

    private final int value;

    LottoConstant(final int value) {
        this.value = value;
    }

    public static void validateIsNumberValidLottoNumber(final int number) {
        if (number < MINIMUM_NUMBER.getValue() || number > MAXIMUM_NUMBER.getValue()) {
            throw new IllegalArgumentException(UNVALID_GOAL_NUMBER.getMessage());
        }
    }

    public static void validateIsNumbersValidLottoLength(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(GOAL_NUMBER_SIZE_EXCEPTION.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
