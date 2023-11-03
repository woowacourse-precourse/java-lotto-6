package lotto.domain;

import static lotto.domain.constants.ExceptionMessage.BE_OUT_OF_RANGE;

public class Number {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int number;


    public Number(String number) {
        this.number = Integer.parseInt(number);
        validateNumberRange(this.number);
    }

    private void validateNumberRange(int number) {
        if (isOutOfNumberRange(number)) {
            throw new IllegalArgumentException(BE_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfNumberRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }


}
