package lotto.domain;

import lotto.exception.OverRangeBonusNumberException;
import lotto.message.ExceptionMessage;
import lotto.message.NumberUsedLotto;

public record BonusNumber(int number) {
    public BonusNumber {
        validateRange(number);
    }

    private void validateRange(int number) {
        if (number > NumberUsedLotto.MAX_LANGE.getNumber()
                || number < NumberUsedLotto.MIN_RANGE.getNumber()) {
            String exceptionMessage = ExceptionMessage.IS_OVER_RANGE_BONUS.toString();
            throw new OverRangeBonusNumberException(exceptionMessage);
        }
    }
}
