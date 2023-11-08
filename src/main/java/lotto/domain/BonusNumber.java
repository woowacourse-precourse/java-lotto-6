package lotto.domain;

import lotto.Config;
import lotto.InputException;

public class BonusNumber {
    private static final String RANGE_ERROR_MESSAGE = "1 ~ 45 범위의 숫자만 입력 가능합니다.";

    private final int number;

    public BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public boolean isEqual(int number) {
        return this.number == number;
    }

    private void validateRange(int number) {
        if (number < Config.MIN.getValue() || number > Config.MAX.getValue()) {
            throw new InputException(RANGE_ERROR_MESSAGE);
        }
    }
}
