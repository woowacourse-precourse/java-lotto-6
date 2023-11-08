package lotto.domain.lotto;

import lotto.constants.lotto.LottoRule;
import lotto.exception.BonusNumberContainLottoException;
import lotto.exception.LottoNumberRangeException;

import java.util.List;

public class BonusNumber {
    private final Integer value;

    private BonusNumber(Integer bonusNumber, Lotto lotto) {
        validateContainLotto(bonusNumber, lotto);
        validateLottoRange(bonusNumber);
        this.value = bonusNumber;
    }

    public static BonusNumber of(Integer bonusNumber, Lotto lotto) {
        return new BonusNumber(bonusNumber, lotto);
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

    private boolean isInRange(Integer num) {
        return num < LottoRule.START_NUMBER || num > LottoRule.END_NUMBER;
    }

    public boolean isMatchBonusNumber(Integer bonusNumber) {
        return value.equals(bonusNumber);
    }
}
