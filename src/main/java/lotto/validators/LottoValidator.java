package lotto.validators;

import static lotto.constant.LottoConfig.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoConfig.MIN_LOTTO_NUMBER;
import static lotto.constant.LottoConfig.TOTAL_CHOICE_NUMBER;

import java.util.List;
import lotto.constant.ErrorMessages;

public class LottoValidator {

    public static void validateNumbersLength(List<Integer> numbers) {
        if (!isValidateNumbersLength(numbers)) {
            throw new IllegalArgumentException(String.format(ErrorMessages.LOTTO_CHOICE_NUMBER, TOTAL_CHOICE_NUMBER.getValue()));
        }
    }

    public static void validateNumbersRange(List<Integer> numbers) {
        if (!isValidateNumbersRange(numbers)) {
            throw new IllegalArgumentException(String.format(ErrorMessages.LOTTO_NUMBER_RANGE, MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue()));
        }
    }

    public static void validateDuplicatedNumbers(List<Integer> numbers) {
        if (isDuplicatedNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBER);
        }
    }

    private static boolean isValidateNumbersLength(List<Integer> numbers) {
        return numbers.size() == TOTAL_CHOICE_NUMBER.getValue();
    }

    private static boolean isValidateNumbersRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> (MIN_LOTTO_NUMBER.getValue() <= number) && (number <= MAX_LOTTO_NUMBER.getValue()));
    }

    private static boolean isDuplicatedNumbers(List<Integer> numbers) {
        int distinctNumbersSize = numbers.stream()
                .distinct()
                .toList()
                .size();

        return numbers.size() != distinctNumbersSize;
    }
}
