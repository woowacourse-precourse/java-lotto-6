package lotto.domain;

import lotto.ErrorMessage;

public class LottoDrawMachine {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final Lotto lottoNumber;
    private final int bonusNumber;

    public LottoDrawMachine(Lotto lottoNumber, int bonusNumber) {
        this.lottoNumber = lottoNumber;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int number) {
        checkValidRange(number);
    }

    private void checkValidRange(int number) {
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE_LOW.getMessage());
        }
        if (number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE_HIGH.getMessage());
        }
    }
}
