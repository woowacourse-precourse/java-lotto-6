package lotto.domain;

import lotto.LottoConstants;
import lotto.StringConstants;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, String bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = validateAndParseBonusNumber(bonusNumber);
    }

    private int validateAndParseBonusNumber(String bonusNumber) {
        try {
            int number = Integer.parseInt(bonusNumber);
            validateBonusNumber(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(StringConstants.FIRST_ERROR_MESSAGE
                                                       + StringConstants.BONUS_NUMBER_NOT_DIGIT_EXCEPTION_MESSAGE);
        }
    }

    private void validateBonusNumber(int number) {
        if (bonusNumberWrongRange(number)) {
            throw new IllegalArgumentException(StringConstants.FIRST_ERROR_MESSAGE
                                                       + StringConstants.BONUS_NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
        if (bonusNumberDuplicateWinningNumbers(number)) {
            throw new IllegalArgumentException(StringConstants.FIRST_ERROR_MESSAGE
                                                       + StringConstants.BONUS_NUMBER_WINNING_NUMBERS_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public boolean bonusNumberWrongRange(int number) {
        return number < LottoConstants.NUMBER_MIN.getValue() || number > LottoConstants.NUMBER_MAX.getValue();
    }

    public boolean bonusNumberDuplicateWinningNumbers( int number) {
        return winningNumbers.contains(number);
    }

    public int countMatchedNumbers(Lotto lotto) {
        return winningNumbers.countMatchedNumbers(lotto);
    }

    public boolean isMatchedBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}