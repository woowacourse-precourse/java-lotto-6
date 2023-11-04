package lotto.domain;

import lotto.message.ExceptionMessage;

import java.util.List;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number > 45 || number < 0) {
            throw new IllegalArgumentException(ExceptionMessage.IS_OVER_RANGE_BONUS.toString());
        }
    }

    public int getNumber() {
        return number;
    }
}
