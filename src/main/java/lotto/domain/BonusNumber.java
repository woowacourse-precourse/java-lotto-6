package lotto.domain;

import static lotto.utils.constants.ErrorMessageConstants.DUPLICATE_ERROR;
import static lotto.utils.constants.ErrorMessageConstants.ERROR_MESSAGE_HEAD;
import static lotto.utils.constants.ErrorMessageConstants.RANGE_ERROR;
import static lotto.utils.constants.LottoConstants.LOTTO_END_NUMBER;
import static lotto.utils.constants.LottoConstants.LOTTO_START_NUMBER;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber, Lotto mainNumbers) {
        validateBonusNumber(bonusNumber, mainNumbers);
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(int bonusNumber, Lotto mainNumbers) {
        validateNumberRange(bonusNumber);
        validateDuplicate(bonusNumber, mainNumbers);
    }

    private void validateNumberRange(int bonusNumber) {
        if (bonusNumber < LOTTO_START_NUMBER || bonusNumber > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + RANGE_ERROR);
        }
    }

    private void validateDuplicate(int bonusNumber, Lotto mainNumbers) {
        if (mainNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + DUPLICATE_ERROR);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
