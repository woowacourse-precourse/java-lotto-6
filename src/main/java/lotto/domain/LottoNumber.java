package lotto.domain;

import static lotto.domain.LottoRule.*;

public class LottoNumber {

    private final int value;

    private LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static LottoNumber from(int value) {
        return new LottoNumber(value);
    }

    private void validate(int value) {
        validateRange(value);
    }

    private void validateRange(int value) {
        if (value < MIN_LOTTO_NUMBER.getValue() || value > MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException();
        }
    }
}