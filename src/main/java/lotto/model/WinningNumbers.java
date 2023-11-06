package lotto.model;

import lotto.global.ErrorCode;
import lotto.global.constant.LottoNumber;
import lotto.model.exception.LottoNumbersException;

public class WinningNumbers {
    private final LottoNumbers winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(LottoNumbers winningNumbers, int bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(LottoNumbers winningNumbers, int bonusNumber){
        checkBonusNumberWithinTheRange(bonusNumber);
        checkDuplicateBonusNumber(winningNumbers, bonusNumber);

    }

    private void checkBonusNumberWithinTheRange(int bonusNumber) {
        if (bonusNumber > LottoNumber.MAX_LOTTO_NUMBER || bonusNumber < LottoNumber.MIN_LOTTO_NUMBER) {
            throw new LottoNumbersException(ErrorCode.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    private void checkDuplicateBonusNumber(LottoNumbers winningNumbers, int bonusNumber) {
        if (winningNumbers.isContainNumber(bonusNumber)) {
            throw new LottoNumbersException(ErrorCode.LOTTO_NUMBER_DUPLICATED);
        }
    }

    public LottoNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
