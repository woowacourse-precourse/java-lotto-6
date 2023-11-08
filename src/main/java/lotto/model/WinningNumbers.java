package lotto.model;

import lotto.global.ErrorCode;
import lotto.global.constant.LottoNumber;
import lotto.model.exception.LottoNumbersException;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(Lotto winningNumbers, int bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningNumbers, int bonusNumber){
        checkBonusNumberWithinTheRange(bonusNumber);
        checkDuplicateBonusNumber(winningNumbers, bonusNumber);

    }

    private void checkBonusNumberWithinTheRange(int bonusNumber) {
        if (bonusNumber > LottoNumber.MAX_LOTTO_NUMBER || bonusNumber < LottoNumber.MIN_LOTTO_NUMBER) {
            throw new LottoNumbersException(ErrorCode.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    private void checkDuplicateBonusNumber(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.isContainNumber(bonusNumber)) {
            throw new LottoNumbersException(ErrorCode.LOTTO_NUMBER_DUPLICATED);
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
