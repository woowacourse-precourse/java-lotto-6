package lotto.vo;

import static lotto.model.LottoInfo.LOTTO_MAX_NUMBER;
import static lotto.model.LottoInfo.LOTTO_MIN_NUMBER;

import lotto.exception.ExceedsMaxLottoNumberException;
import lotto.exception.LessThanMinLottoNumberException;

public record BonusNumber(Integer number) {

    public BonusNumber {
        validateNumber(number);
    }

    private void validateNumber(final Integer number) {
        if (isLargerThanMaxNumber(number)) {
            throw new ExceedsMaxLottoNumberException();
        }
        if (isLessThanMinNumber(number)) {
            throw new LessThanMinLottoNumberException();
        }
    }

    private boolean isLessThanMinNumber(final Integer number) {
        return number < LOTTO_MIN_NUMBER.getValue();
    }

    private boolean isLargerThanMaxNumber(final Integer number) {
        return number > LOTTO_MAX_NUMBER.getValue();
    }
}
