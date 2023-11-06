package lotto.domain;

import lotto.exception.OverLappingNumbersException;
import lotto.exception.RangeLottoNumberException;

import java.util.List;

import static lotto.domain.Constant.MAX_RANGE;
import static lotto.domain.Constant.MIN_RANGE;

public class WonLotto {
    private final Lotto lotto;
    private final Integer bonusNumber;

    public WonLotto(List<Integer> lotto, Integer bonusNumber) {
        this.lotto = new Lotto(lotto);
        validateNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateNumber(Integer bonusNumber) {
        validateDuplicateBonusNumber(bonusNumber);
        validateRange(bonusNumber);
    }

    public void validateRange(Integer number) {
        if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
            throw new RangeLottoNumberException();
        }
    }

    public void validateDuplicateBonusNumber(Integer bonusNumber) {
        if (isContain(bonusNumber)) {
            throw new OverLappingNumbersException();
        }
    }

    public boolean isContain(int number) {
        return lotto.isContain(number);
    }
}
