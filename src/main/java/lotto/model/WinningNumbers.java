package lotto.model;

import lotto.constant.ErrorMessage;

public class WinningNumbers {
    Lotto winningNumbers;
    BonusNumber bonusNumber;

    WinningNumbers(Lotto winningNumbers, BonusNumber bonusNumber) {
        isNotDuplicate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
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
