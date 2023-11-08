package lotto.model;

import lotto.constant.ErrorConstants;
import lotto.constant.GameConstants;

public class WinningLottoNumbers {

    private final int bonusNumber;
    private final Lotto winningNumbers;

    public WinningLottoNumbers(Lotto winningNumbers, int bonusNumber) {
        validate(winningNumbers,bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumbers, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplication(winningNumbers,bonusNumber);
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < GameConstants.MIN_RANGE || bonusNumber > GameConstants.MAX_RANGE) {
            throw new IllegalArgumentException(ErrorConstants.OVER_LOTTO_RANGE);
        }
    }

    private void validateBonusNumberDuplication(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorConstants.DUPLICATE_LOTTO_NUMBER);
        }
    }


}
