package lotto.domain;

import static lotto.Exception.ExceptionMessage.*;
import static lotto.utils.Constance.*;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER.getValue() || number > LOTTO_MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(RANGE_ERROR.getExceptionMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
