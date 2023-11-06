package lotto.validator;

import java.util.List;
import lotto.domain.Lotto;
import lotto.exception.DuplicatedLottoNumberException;
import lotto.exception.OutOfNumberRangeException;

public class BonusNumberValidator {

    private BonusNumberValidator() {
    }

    public static void checkBonusNumberRangeAndThrowException(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < ValidNumber.LOTTO_NUMBER_MIN_RANGE.getNumber() ||
                bonusNumber > ValidNumber.LOTTO_NUMBER_MAX_RANGE.getNumber()) {
            throw new OutOfNumberRangeException();
        }
    }

    public static void checkWinningLottoAndBonusDuplicated(Lotto winningLotto, int bonusNumber)
            throws IllegalArgumentException {
        List<Integer> numbers = winningLotto.getNumbers();
        if (numbers.contains(bonusNumber)) {
            throw new DuplicatedLottoNumberException();
        }
    }
}
