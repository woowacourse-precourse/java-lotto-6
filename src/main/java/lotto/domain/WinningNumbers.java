package lotto.domain;

import static lotto.constant.LottoInformation.MAX_NUMBER;
import static lotto.constant.LottoInformation.MIN_NUMBER;
import static lotto.constant.message.ErrorMessage.DUPLICATE_BONUS;
import static lotto.constant.message.ErrorMessage.INVALID_NUMBER_RANGE;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean isContain(int number) {
        return winningLotto.isContain(number);
    }

    private void validateBonusNumber(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateDuplicateBonus(winningLotto, bonusNumber);
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (!isValidRange(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private boolean isValidRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    private void validateDuplicateBonus(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
