package lotto.domain;

import lotto.config.ErrorMessages;
import lotto.config.LottoConfig;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(WinningNumber winningNumber, int number) {
        isNumberInRange(number);
        checkBonusNumberInWinningNumber(winningNumber, number);
        bonusNumber = number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void isNumberInRange(int bonusNumber) {
        if (bonusNumber < LottoConfig.MIN_LOTTO_NUMBER || bonusNumber > LottoConfig.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_OUT_OF_RANGE_LOTT_NUMBER.getMessage());
        }
    }

    private void checkBonusNumberInWinningNumber(WinningNumber winingNumber, int bonusNumber) {
        if (winingNumber.getWinningNumber().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }
}
