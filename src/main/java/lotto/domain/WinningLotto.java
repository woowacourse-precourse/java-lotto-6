package lotto.domain;

import static lotto.domain.enums.Constant.LOTTO_MAX_NUMBER;
import static lotto.domain.enums.Constant.LOTTO_MIN_NUMBER;
import static lotto.domain.enums.ErrorMessage.DUPLICATE_NUMBER_ERROR_MESSAGE;
import static lotto.domain.enums.ErrorMessage.NUMBER_OUT_OF_RANGE_ERROR_MESSAGE;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumbers, int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicateNumber(winningNumbers, bonusNumber);

    }

    private void validateDuplicateNumber(final Lotto winningNumbers, final int bonusNumber) {
        if (winningNumbers.isContainNumber(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateNumberRange(final int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isOutOfRange(final int bonusNumber) {
        return bonusNumber < LOTTO_MIN_NUMBER.getConstant() || bonusNumber > LOTTO_MAX_NUMBER.getConstant();
    }
}
