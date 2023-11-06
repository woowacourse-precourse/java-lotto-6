package lotto.validator;

import static lotto.Option.ErrorMessage.NOT_BONUS_DUPLICATION;
import static lotto.Option.ErrorMessage.NOT_SIX_LENGTH;
import static lotto.Option.ErrorMessage.ONE_TO_FORTY_FIVE;

import java.util.List;
import lotto.Option.GameOption;

public class LottoValidator {
    public static void go(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_SIX_LENGTH.getErrorMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < GameOption.LOTTO_MIN_NUMBER.getNumber() || number > GameOption.LOTTO_MAX_NUMBER.getNumber()) {
                throw new IllegalArgumentException(ONE_TO_FORTY_FIVE.getErrorMessage());
            }
        });
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (isDuplication(numbers)) {
            throw new IllegalArgumentException(NOT_BONUS_DUPLICATION.getErrorMessage());
        }
    }

    private static boolean isDuplication(List<Integer> validator) {
        return validator.stream()
                .distinct()
                .count() != validator.size();
    }
}
