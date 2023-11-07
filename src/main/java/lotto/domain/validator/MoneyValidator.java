package lotto.domain.validator;

import java.util.List;

public class MoneyValidator {
    private static final Integer MIN_AMMOUNT = 1000;
    private static final String MESSAGE_RANGE_ERROR = "[ERROR]: 1000원 이상의 금액을 입력해주세요.";

    public MoneyValidator(Integer number) {
        validateRange(number);
    }

    private void validateRange(Integer number) {
        if (number < MIN_AMMOUNT) {
            throw new IllegalArgumentException(MESSAGE_RANGE_ERROR);
        }
    }
}
