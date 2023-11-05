package lotto.domain;

import java.util.BitSet;
import lotto.constants.ErrorMessages;
import lotto.validator.impl.BonusNumberValidator;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(String bonusNumber, BitSet winningNumbersBitSet) {
        validate(bonusNumber,winningNumbersBitSet);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validate(String bonusNumber, BitSet winningNumbersBitSet) {
        isInWinningNumbers(bonusNumber, winningNumbersBitSet);
        new BonusNumberValidator().validate(bonusNumber);
    }

    private void isInWinningNumbers(String bonusNumber, BitSet winningNumbersBitSet) {
        if (winningNumbersBitSet.get(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
