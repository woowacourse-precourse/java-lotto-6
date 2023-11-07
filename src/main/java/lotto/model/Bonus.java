package lotto.model;

import lotto.exception.ErrorType;

public class Bonus {

    private Number bonusNumber;

    public Bonus(Number bonusNumber, WinningLotto winningLotto) {
        validateDuplicatedInWinningLotto(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }

    private void validateDuplicatedInWinningLotto(Number bonusNumber, WinningLotto winningLotto) {
        if (isDuplicate(bonusNumber, winningLotto)) {
            throw new IllegalArgumentException(ErrorType.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    private boolean isDuplicate(Number bonusNumber, WinningLotto winningLotto) {
        return winningLotto.getWinningNumbers().contains(bonusNumber.getNumber());
    }
}
