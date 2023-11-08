package lotto.validator;

import java.util.List;
import java.util.regex.Pattern;
import lotto.domain.Lotto;
import lotto.exception.ErrorMessage;

public class WinningLottoValidator {
    public static final String DELIMITER = ",";
    public static final String WINNING_NUMBERS_REGEX = "^[0-9,]+$";


    public static void inputValidate(final String input) {
        if (InputValidator.isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_VALUE_MESSAGE.getMessage());
        }

        if (!isMatchedWinningNumbersRegex(input)) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_NUMBERS_AND_DELIMITERS_ONLY_MESSAGE.getMessage());
        }
    }

    private static boolean isMatchedWinningNumbersRegex(final String input) {
        return Pattern.matches(WINNING_NUMBERS_REGEX, input);
    }

    public static void validateWinningNumbers(final List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumbersInLottoRange(numbers);
        validateDuplicateNumbers(numbers);
    }

    private static void validateNumberSize(final List<Integer> numbers) {
        if (numbers.size() != Lotto.SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE_MESSAGE.getMessage());
        }
    }

    private static void validateNumbersInLottoRange(final List<Integer> numbers) {
        boolean anyMatch = numbers.stream()
                .anyMatch(number -> number < Lotto.MIN_LOTTO_NUMBER || number > Lotto.MAX_LOTTO_NUMBER);

        if (anyMatch) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_WINNING_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    private static void validateDuplicateNumbers(final List<Integer> numbers) {
        for (Integer number : numbers) {
            long count = numbers.stream().filter(num -> num.equals(number)).count();

            if (count > 1) {
                throw new IllegalArgumentException(
                        ErrorMessage.DUPLICATE_NUMBERS_MESSAGE.getMessage());
            }
        }
    }
}
