package lotto.domain;

import lotto.constants.LottoConstants;
import lotto.exception.ErrorMessage;

public class BonusNumber {
    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber create(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    private void validate(int bonusNumber) {
        if (!validateNumberArrange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ARRANGE.getErrorMessage());
        }
    }

    private boolean validateNumberArrange(int bonusNumber) {
        return bonusNumber >= LottoConstants.RANDOM_MIN_NUMBER.getNumber()
                && bonusNumber <= LottoConstants.RANDOM_MAX_NUMBER.getNumber();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

