package lotto.domain;

import static lotto.constants.ExceptionMessage.BE_OUT_OF_RANGE;
import static lotto.constants.ExceptionMessage.HAS_LETTER;

public class Number {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int number;


    public Number(String number) {
        validateType(number);
        this.number = Integer.parseInt(number);
        validateNumberRange(this.number);
    }

    private void validateType(String number) {
        if (hasLetter(number)) {
            throw new IllegalArgumentException(HAS_LETTER.getMessage());
        }
    }

    private boolean hasLetter(String number) {
        return number.chars()
                .anyMatch(c -> !Character.isDigit(c));
    }

    private void validateNumberRange(int number) {
        if (isOutOfNumberRange(number)) {
            throw new IllegalArgumentException(BE_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfNumberRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

    public int getNumber() {
        return number;
    }
}
