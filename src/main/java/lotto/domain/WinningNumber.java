package lotto.domain;

import lotto.validator.LottoNumberValidator;

import java.util.List;

import static lotto.constants.GameNumberConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.GameNumberConstants.MIN_LOTTO_NUMBER;
import static lotto.validator.LottoNumberValidator.*;
import static lotto.validator.LottoNumberValidator.validateNumberRange;

public class WinningNumber {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumber(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;

    }

    private void validateBonusNumber(int bonusNumber) {
        validateNumberRange(bonusNumber);
    }


}
