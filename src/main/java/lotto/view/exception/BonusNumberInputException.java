package lotto.view.exception;

import lotto.view.message.exception.BonusNumberInputExceptionMessage;

public class BonusNumberInputException extends IllegalArgumentException {
    private BonusNumberInputException(final BonusNumberInputExceptionMessage bonusNumberInputExceptionMessage) {
        super(bonusNumberInputExceptionMessage.getMessage());
    }

    public static BonusNumberInputException of(
            final BonusNumberInputExceptionMessage bonusNumberInputExceptionMessage) {
        return new BonusNumberInputException(bonusNumberInputExceptionMessage);
    }
}
