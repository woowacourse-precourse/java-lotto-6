package lotto.domain;

import lotto.message.ErrorMessage;

public class LottoDrawMachine {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final Lotto lotto;
    private final int bonusNumber;

    public LottoDrawMachine(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        checkValidRange(bonusNumber);
        checkDuplicate(bonusNumber);
    }

    private void checkValidRange(int number) {
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE_LOW.getMessage());
        }
        if (number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE_HIGH.getMessage());
        }
    }

    private void checkDuplicate(int bonusNumber) {
        if (this.lotto.matchesBonus(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WITH_LOTTO.getMessage());
        }
    }

}
