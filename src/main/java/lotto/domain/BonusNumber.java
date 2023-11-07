package lotto.domain;

import lotto.exception.OverRangeBonusNumberException;
import lotto.message.ExceptionMessage;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number > 45 || number < 0) {
            String exceptionMessage = ExceptionMessage.IS_OVER_RANGE_BONUS.toString();
            throw new OverRangeBonusNumberException(exceptionMessage);
        }
    }

    public int getNumber() {
        return number;
    }
}
