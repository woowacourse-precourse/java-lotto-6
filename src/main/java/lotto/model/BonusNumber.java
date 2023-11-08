package lotto.model;

import static lotto.Constraints.MAX_NUMBER;
import static lotto.Constraints.MIN_NUMBER;

import lotto.model.exceptions.OutOfRangeNumberException;

public record BonusNumber(int number) {

    public BonusNumber {
        validate(number);
    }

    private void validate(int number) {
        validateInRangeNumber(number);
    }

    // 범위 밖 숫자 검증
    private static void validateInRangeNumber(int number) {
        if (number > MAX_NUMBER.getValue() || number < MIN_NUMBER.getValue()) {
            throw new OutOfRangeNumberException();
        }
    }
}
