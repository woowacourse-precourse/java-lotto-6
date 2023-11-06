package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.validator.LottoValidator;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers extends Lotto {
    private static final String NUMBERS_DELIMITER = ",";
    private final List<Integer> numbers;

    private WinningNumbers(List<Integer> numbers) {
        super(numbers);
        this.numbers = numbers;
    }

    public static WinningNumbers create(String input) {
        List<Integer> validInput = validate(input);
        return new WinningNumbers(validInput);
    }

    private static List<Integer> validate(String input) {
        validateBlank(input);
        validateStartsOrEndsWithDelimiter(input);
        return parseWinningNumbersInput(input);
    }

    private static void validateBlank(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_BLANK.getMessage());
        }
    }

    private static void validateStartsOrEndsWithDelimiter(String input) {
        if (input.startsWith(NUMBERS_DELIMITER) || input.endsWith(NUMBERS_DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_STARTS_OR_ENDS_WITH_DELIMITER.getMessage());
        }
    }

    private static List<Integer> parseWinningNumbersInput(String input) {
        return Arrays.stream(input.split(NUMBERS_DELIMITER))
                .map(WinningNumbers::safeParseInt)
                .toList();
    }

    private static Integer safeParseInt(String input) {
        try {
            int number = Integer.parseInt(input);
            LottoValidator.validateRange(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_NOT_NUMERIC.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
