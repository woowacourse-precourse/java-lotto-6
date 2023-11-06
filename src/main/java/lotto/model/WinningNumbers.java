package lotto.model;

import static lotto.model.constant.ErrorMessage.NUMBER_DUPLICATED;
import static lotto.model.constant.ErrorMessage.NUMBER_INVALID_RANGE;
import static lotto.model.constant.LottoConfig.MAXIMUM_LOTTO_NUMBER;
import static lotto.model.constant.LottoConfig.MINIMUM_LOTTO_NUMBER;

public class WinningNumbers {

    private Lotto winningNumbers;
    private Integer bonusNumber;

    private WinningNumbers(Lotto lotto, Integer bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicateWithWinningNumbers(lotto, bonusNumber);
        this.winningNumbers = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(Lotto lotto, Integer bonusNumber) {
        return new WinningNumbers(lotto, bonusNumber);
    }

    public boolean hasNumberInWinningNumbers(Integer number) {
        return winningNumbers.hasNumber(number);
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateDuplicateWithWinningNumbers(Lotto lotto, Integer bonusNumber) {
        if (lotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(NUMBER_DUPLICATED);
        }
    }

    private void validateNumberRange(Integer bonusNumber) {
        if (bonusNumber < MINIMUM_LOTTO_NUMBER || bonusNumber > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(NUMBER_INVALID_RANGE);
        }
    }
}
