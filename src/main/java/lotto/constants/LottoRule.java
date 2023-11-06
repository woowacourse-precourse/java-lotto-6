package lotto.constants;

import static lotto.exception.ExceptionMessage.GOAL_NUMBER_SIZE_EXCEPTION;
import static lotto.exception.ExceptionMessage.MONEY_REMAIN_EXCEPTION;
import static lotto.exception.ExceptionMessage.UNVALID_GOAL_NUMBER;

import lotto.model.LottoNumber;
import java.util.List;

public enum LottoRule {

    MINIMUM_NUMBER(1),
    MAXIMUM_NUMBER(45),
    MINIMUM_MATCH_SIZE(3),
    LOTTO_NUMBER_LENGTH(6),
    LOTTO_COST(1000),
    LOTTO_COST_REMAIN_VALUE(0);

    private final int value;

    LottoRule(final int value) {
        this.value = value;
    }

    public static void validateNumbersLength(final List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH.value) {
            throw new IllegalArgumentException(GOAL_NUMBER_SIZE_EXCEPTION.getMessage());
        }
    }

    public static void validateNumberValue(final int number) {
        if (number > MAXIMUM_NUMBER.value || number < MINIMUM_NUMBER.value) {
            throw new IllegalArgumentException(UNVALID_GOAL_NUMBER.getMessage());
        }
    }

    public static void validateInvestMoney(final int number) {
        if (number % LOTTO_COST.getValue() != LOTTO_COST_REMAIN_VALUE.getValue()) {
            throw new IllegalArgumentException(MONEY_REMAIN_EXCEPTION.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
