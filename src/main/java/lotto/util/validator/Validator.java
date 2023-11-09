package lotto.util.validator;

import static lotto.util.Constant.*;
import static lotto.util.ErrorMessage.*;

import java.util.regex.Pattern;

public abstract class Validator<T> {

    public void validateNumber(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_NUMERIC.getMessage());
        }
    }

    public void validateNumberRange(int number) {
        if (number < LOTTO_MINIMUM_RANGE || number > LOTTO_MAXIMUM_RANGE) {
            throw new IllegalArgumentException(INVALID_OUT_OF_RANGE.getMessage());
        }
    }
}
