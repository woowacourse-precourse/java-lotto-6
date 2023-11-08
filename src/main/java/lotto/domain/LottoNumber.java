package lotto.domain;

import lotto.Utils;

import static lotto.Constants.LOTTO_MAX_NUMBER;
import static lotto.Constants.LOTTO_MIN_NUMBER;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public LottoNumber(String input) {
        this(Utils.convertStringToInt(input));
    }

    public int getNumber() {
        return this.number;
    }

    private void validate(int number) {
        if (LOTTO_MAX_NUMBER < number || number < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.get(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
        }
    }
}
