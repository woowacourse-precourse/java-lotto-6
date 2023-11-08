package lotto.domain.exception.bonusNumberException;

import lotto.view.ExceptionMessage;

public class BonusNumberContainedException extends IllegalArgumentException {

    public BonusNumberContainedException() {
        super(ExceptionMessage.CONTAINED_EXCEPTION.getErrorMessage());
    }
}
