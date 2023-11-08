package lotto.domain;

import lotto.utils.ErrorMessage;

public class BonusNumber {
    private final WinningNumber bonusNumber;

    public BonusNumber(final WinningNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber createBonusNumber(final WinningNumber bonusNumber, final WinningNumbers winningNumbers) {
        validateUnique(bonusNumber, winningNumbers);

        return new BonusNumber(bonusNumber);
    }

    public boolean isBonusNumber(final int lottoNumber) {
        return bonusNumber.isNumberExist(lottoNumber);
    }

    private static void validateUnique(final WinningNumber bonusNumber, final WinningNumbers winningNumbers) {
        if (winningNumbers.isNumberExist(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }
}
