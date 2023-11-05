package lotto.domain;

import static lotto.constant.ExceptionMessage.OUT_OF_LOTTO_RANGE_MESSAGE;

public class WinningNumber {

    private final int number;

    public WinningNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if(number < 1 || 45 < number) {
            throw new IllegalArgumentException(OUT_OF_LOTTO_RANGE_MESSAGE.getMessage());
        }
    }

    public boolean is(int number) {
        return this.number == number;
    }

}
