package lotto.model;

import lotto.message.ExceptionMessage;
import lotto.validator.Validator;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(Lotto winnerLotto, int bonusNumber) {
        validate(winnerLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winnerLotto, int bonusNumber) {
        Validator.validateNumberInRange(bonusNumber);
        validateNotInWinnerNumbers(winnerLotto, bonusNumber);
    }

    private static void validateNotInWinnerNumbers(Lotto winnerLotto, int bonusNumber) {
        if (winnerLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_DUPLICATED_NUMBER.getMessage());
        }
    }

    public boolean isPartOf(Lotto userLotto) {
        return userLotto.contains(bonusNumber);
    }

}
