package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;

public class BonusNumber implements LottoConstants {
    final int bonusNumber;

    public BonusNumber(int bonusNumber, Lotto winningNumber) {
        validate(bonusNumber, winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean isMatch(Lotto lotto, int matchCount) {
        return ((matchCount == LOTTO_SIZE - 1) && (lotto.contains(bonusNumber) == 1));
    }

    private void validate(int number, Lotto winningNumber) {
        if (winningNumber.contains(number) == 1) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_OF_WINNING_NUMBERS.toString());
        }
        if ((number < MIN_NUMBER) || (number > MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.toString());
        }
    }
}
