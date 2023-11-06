package lotto.domain;

import static lotto.domain.LottoNumberGenerator.END_INCLUSIVE;
import static lotto.domain.LottoNumberGenerator.START_INCLUSIVE;
import static lotto.exception.ExceptionMessage.LOTTO_NUMBER_RANGE;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public void validateNumberRange(int number) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            throw LOTTO_NUMBER_RANGE.getException(START_INCLUSIVE, END_INCLUSIVE);
        }
    }

    public int getNumber() {
        return number;
    }
}
