package lotto.domain;

import java.util.BitSet;
import lotto.constants.ErrorMessages;
import lotto.util.Parser;
import lotto.validator.impl.BonusNumberValidator;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumber, BonusNumberValidator bonusNumberValidator) {
        validate(bonusNumber, bonusNumberValidator);
        this.bonusNumber = Parser.parseToInt(bonusNumber);
    }

    private void validate(String bonusNumber, BonusNumberValidator bonusNumberValidator) {
        bonusNumberValidator.validate(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validateDuplicatedWithWinning(BitSet winningNumbersBitSet) {
        if (winningNumbersBitSet.get(this.bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
