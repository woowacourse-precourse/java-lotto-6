package lotto.model;

import static lotto.exception.ExceptionMessage.NUMBER_FORMAT_EXCEPTION;

import lotto.constants.LottoRule;
import java.util.Objects;

public class LottoNumber {

    private final int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber from(final String numberInput) {
        int number = convertToNumber(numberInput);
        LottoRule.validateNumberValue(number);

        return new LottoNumber(number);
    }

    private static int convertToNumber(final String numberInput) {
        try {
            return Integer.parseInt(numberInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) other;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
