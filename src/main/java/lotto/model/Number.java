package lotto.model;

import java.util.Objects;
import lotto.exception.Constant;
import lotto.exception.ErrorMessage;

public class Number {

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        validateNumber(number);
        return new Number(number);
    }

    private static void validateNumber(int number) {
        if ((number < Constant.LOTTO_NUMBER_MIN.getIntValue()) || (number > Constant.LOTTO_NUMBER_MAX.getIntValue())) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_RANGE.get());
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
