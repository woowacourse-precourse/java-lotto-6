package lotto.validator;

import static lotto.enums.ExceptionCase.NUMBERS_SIZE_MISMATCH;
import static lotto.enums.ExceptionCase.NUMBER_DUPLICATION;
import static lotto.enums.ExceptionCase.NUMBER_OUT_OF_RANGE;
import static lotto.enums.NumberCondition.LOTTO_MAX;
import static lotto.enums.NumberCondition.LOTTO_MIN;
import static lotto.enums.NumberCondition.LOTTO_SIZE;

import java.util.List;

public class LottoValidator {

    public static void validateNumbers(List<Integer> numbers) {
        if (!correctSize(numbers)) {
            throw new IllegalArgumentException(NUMBERS_SIZE_MISMATCH.message());
        }
        if (!unique(numbers)) {
            throw new IllegalArgumentException(NUMBER_DUPLICATION.message());
        }
        if (!inRange(numbers)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.message());
        }
    }

    private static boolean correctSize(List<Integer> numbers) {
        return numbers.size() == LOTTO_SIZE.number();
    }

    private static boolean unique(List<Integer> numbers) {
        return numbers.size() == numbers.stream().distinct().count();
    }

    private static boolean inRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number >= LOTTO_MIN.number() && number <= LOTTO_MAX.number());
    }
}
