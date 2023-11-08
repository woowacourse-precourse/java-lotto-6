package lotto.domain;

import lotto.util.ErrorMessage;
import lotto.util.LottoConstants;

public class BonusNumber implements LottoConstants {
    final int bonusNumber;

    public BonusNumber(int bonusNumber, Lotto winningNumber) {
        validate(bonusNumber, winningNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int number, Lotto winningNumber) {
        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_OF_WINNING_NUMBERS.getMessage());
        }
        if ((number < MIN_NUMBER) || (number > MAX_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage(MIN_NUMBER, MAX_NUMBER));
        }
    }
}
