package lotto.domain;

import static lotto.utils.constants.ErrorMessageConstants.DUPLICATE_ERROR;
import static lotto.utils.constants.ErrorMessageConstants.ERROR_MESSAGE_HEAD;
import static lotto.utils.constants.ErrorMessageConstants.RANGE_ERROR;
import static lotto.utils.constants.LottoConstants.LOTTO_END_NUMBER;
import static lotto.utils.constants.LottoConstants.LOTTO_START_NUMBER;

public class WinningNumbers {

    private final Lotto mainNumbers;
    private final int bonusNumber;

    public WinningNumbers(Lotto mainNumbers, int bonusNumber) {
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    public Lotto getMainNumbers() {
        return mainNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void validateBonusNumber() {
        validateDuplicate();
        validateNumberRange();
    }

    private void validateNumberRange() {
        if (bonusNumber < LOTTO_START_NUMBER || bonusNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + RANGE_ERROR);
        }
    }

    private void validateDuplicate() {
        if (mainNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + DUPLICATE_ERROR);
        }
    }

}
