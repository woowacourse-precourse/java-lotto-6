package lotto;

import lotto.constants.LottoConstants;
import lotto.exception.LottoErrorCode;

public record Lottery(
        Lotto lotto,
        Integer bonusNumber
) {
    public Lottery {
        validateAllUnique(lotto, bonusNumber);
        validateLottoNumber(bonusNumber);
    }

    private void validateAllUnique(Lotto lotto, Integer bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoErrorCode.DUPLICATED_NUMBER.getMessage());
        }
    }

    private void validateLottoNumber(Integer bonusNumber) {
        if (LottoConstants.LOTTO_MIN > bonusNumber || bonusNumber > LottoConstants.LOTTO_MAX) {
            throw new IllegalArgumentException(LottoErrorCode.OUT_OF_RANGE.getMessage());
        }
    }

}
