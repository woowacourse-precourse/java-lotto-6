package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.exception.ExceptionMessage;

public class LottoBonusNumber {

    private final int bonusNumber;

    public LottoBonusNumber(LottoWinningNumber lottoWinningNumber, int bonusNumber) {
        validateDuplicate(lottoWinningNumber, bonusNumber);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(LottoWinningNumber lottoWinningNumber, int bonusNumber) {
        if (lottoWinningNumber.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_DUPLICATED);
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LottoConstant.LOTTO_START_NUMBER ||
                bonusNumber > LottoConstant.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_OUT_OF_BOUND);
        }
    }

    public boolean matches(int bonusNumber) {
        return this.bonusNumber == bonusNumber;
    }

}
