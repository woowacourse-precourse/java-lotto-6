package lotto.validator;

import java.util.List;
import java.util.regex.Pattern;
import lotto.domain.Lotto;

public class WinningLottoValidator {
    public static final String DELIMITER = ",";
    public static final String WINNING_NUMBERS_REGEX = "^[0-9,]+$";
    public static final String ENTER_NUMBERS_AND_DELIMITERS_ONLY_MESSAGE =
            "당첨 번호는 숫자와 '" + DELIMITER + "'만을 사용하여 입력해주세요.";
    public static final String INVALID_LOTTO_NUMBER_RANGE_MESSAGE =
            "당첨 번호를 " + Lotto.MIN_LOTTO_NUMBER + " ~ " + Lotto.MAX_LOTTO_NUMBER + " 사이의 숫자로 입력해주세요.";


    public static void inputValidate(final String input) {
        if (InputValidator.isEmpty(input)) {
            throw new IllegalArgumentException(InputValidator.ENTER_VALUE_MESSAGE);
        }

        if (!isMatchedWinningNumbersRegex(input)) {
            throw new IllegalArgumentException(ENTER_NUMBERS_AND_DELIMITERS_ONLY_MESSAGE);
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
            throw new IllegalArgumentException(LottoValidator.INVALID_LOTTO_SIZE_MESSAGE);
        }
    }

    private static void validateNumbersInLottoRange(final List<Integer> numbers) {
        boolean anyMatch = numbers.stream()
                .anyMatch(number -> number < Lotto.MIN_LOTTO_NUMBER || number > Lotto.MAX_LOTTO_NUMBER);

        if (anyMatch) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
        }
    }

    private static void validateDuplicateNumbers(final List<Integer> numbers) {
        for (Integer number : numbers) {
            long count = numbers.stream().filter(num -> num.equals(number)).count();

            if (count > 1) {
                throw new IllegalArgumentException(LottoValidator.DUPLICATE_NUMBERS_MESSAGE);
            }
        }
    }
}
