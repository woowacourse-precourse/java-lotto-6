package lotto.domain;

import lotto.utils.ErrorMessage;

public class BonusNumber {
    private final WinningNumber bonusNumber;

    public BonusNumber(WinningNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber createBonusNumber(WinningNumber bonusNumber, WinningNumbers winningNumbers) {
        validateUnique(bonusNumber, winningNumbers);

        return new BonusNumber(bonusNumber);
    }

    public boolean isBonusNumber(int lottoNumber) {
        return bonusNumber.isNumberExist(lottoNumber);
    }

    private static void validateUnique(WinningNumber bonusNumber, WinningNumbers winningNumbers) {
        if (winningNumbers.isNumberExist(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_VALUES.getErrorMessage());
        }
    }
}
