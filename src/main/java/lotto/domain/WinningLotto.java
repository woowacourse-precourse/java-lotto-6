package lotto.domain;

import lotto.exception.ErrorMessage;

public class WinningLotto {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    private WinningLotto(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto create(WinningNumbers winningNumbers, int number) {
        BonusNumber bonusNumber = BonusNumber.from(number);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void validateBonusNumber(BonusNumber bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
