package lotto.validator;

import static lotto.util.Constants.LOTTO_SIZE;
import static lotto.util.Constants.MAX_LOTTO_NUM;
import static lotto.util.Constants.MIN_LOTTO_NUM;

import java.util.List;
import lotto.message.ExceptionMessage;

public class LottoValidator {

    public static void validate(List<Integer> numbers) {
        validateNumberLength(numbers);
        validateDuplicatedNumber(numbers);
        validateNumberInRange(numbers);
    }

    private static void validateNumberLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_NUMBER_LENGTH.getMessage());
        }
    }

    private static void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_DUPLICATED_NUMBER.getMessage());
        }
    }

    private static void validateNumberInRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
                throw new IllegalArgumentException(ExceptionMessage.NUMBER_NOT_IN_RANGE.getMessage());
            }
        });
    }

}
