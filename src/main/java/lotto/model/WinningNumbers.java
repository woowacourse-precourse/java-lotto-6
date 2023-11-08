package lotto.model;

import lotto.constants.ErrorMessages;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningNumbers(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        checkBonusNumberInWinningLotto(winningLotto, bonusNumber);
    }

    private void checkBonusNumberInWinningLotto(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_NOT_ALLOWED_MESSAGE);
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }

}
