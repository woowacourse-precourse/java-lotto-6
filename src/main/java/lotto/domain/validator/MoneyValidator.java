package lotto.domain.validator;

import java.util.List;

public class MoneyValidator {
    private static final Integer MIN_AMMOUNT = 1000;
    private static final String MESSAGE_RANGE_ERROR = "[ERROR]: 1000원 이상의 금액을 입력해주세요.";
    private static final String MESSAGE_DIVISIBLE_ERROR = "[ERROR]: 1000원으로 나누어 떨어지는 금액을 입력하세요.";

    public MoneyValidator(Integer number) {
        validateRange(number);
        validateDivisibleBy1000(number);
    }

    private void validateRange(Integer number) {
        if (number < MIN_AMMOUNT) {
            throw new IllegalArgumentException(MESSAGE_RANGE_ERROR);
        }
    }

    private void validateDivisibleBy1000(Integer number) {
        if (number % 1000 != 0) {
            throw new IllegalArgumentException(MESSAGE_DIVISIBLE_ERROR);
        }
    }
}
