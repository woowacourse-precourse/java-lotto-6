package lotto.domain;

import lotto.constant.LottoConfig;

import static lotto.constant.ExceptionMessage.OUT_OF_LOTTO_RANGE_MESSAGE;

public class WinningNumber {

    private final int number;

    public WinningNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < LottoConfig.LOTTO_NUMBER_FROM || LottoConfig.LOTTO_NUMBER_TO < number) {
            throw new IllegalArgumentException(OUT_OF_LOTTO_RANGE_MESSAGE);
        }
    }

    public boolean is(int number) {
        return this.number == number;
    }

    public boolean is(WinningNumber winningNumber) {
        return this.number == winningNumber.number;
    }

}
