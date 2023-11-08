package lotto.model;

import lotto.constant.ErrorMessage;

public class WinningNumbers {
    Lotto winningNumbers;
    BonusNumber bonusNumber;

    public WinningNumbers(Lotto winningNumbers, BonusNumber bonusNumber) {
        isNotDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers makeWinningNumbers(Lotto winningNumbers, BonusNumber bonusNumber) {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public Lotto getWinningNumbers() {
        return this.winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return this.bonusNumber;
    }

    private void isNotDuplicate(Lotto winningNumbers, BonusNumber bonusNumber) {
        for (Integer lottoNumber : winningNumbers.getLottoNumbers()) {
            if (bonusNumber.getBonusNumber() == lottoNumber) {
                throw new IllegalArgumentException(ErrorMessage
                        .DUPLICATE_ERROR_MESSAGE.getErrorMessage());
            }
        }
    }
}
