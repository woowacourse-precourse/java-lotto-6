package lotto.domain;

import lotto.constants.LottoRule;
import lotto.exception.BonusNumberContainLottoException;
import lotto.exception.LottoNumberRangeException;

import java.util.List;

public class BonusNumber {
    private final Integer value;

    public BonusNumber(Integer bonusNumber, Lotto lotto) {
        validateContainLotto(bonusNumber, lotto);
        validateLottoRange(bonusNumber);
        this.value = bonusNumber;
    }

    private void validateContainLotto(Integer bonusNumber, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        if (lottoNumbers.contains(bonusNumber)) {
            throw new BonusNumberContainLottoException();
        }
    }

    private void validateLottoRange(Integer bonusNumber) {
        if (isInRange(bonusNumber)) {
            throw new LottoNumberRangeException();
        }
    }

    private static boolean isInRange(Integer num) {
        return num >= LottoRule.START_NUMBER && num <= LottoRule.END_NUMBER;
    }
}
