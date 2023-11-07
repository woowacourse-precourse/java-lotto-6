package lotto.validator;

import static lotto.util.Constants.MAX_LOTTO_NUM;
import static lotto.util.Constants.MIN_LOTTO_NUM;

import java.util.List;
import lotto.message.ExceptionMessage;

public class Validator {
    public static void validateNumbersInRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            validateNumberInRange(number);
        });
    }

    public static void validateNumberInRange(int number) {
        if (number > MAX_LOTTO_NUM || number < MIN_LOTTO_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_NOT_IN_RANGE.getMessage());
        }
    }

}
