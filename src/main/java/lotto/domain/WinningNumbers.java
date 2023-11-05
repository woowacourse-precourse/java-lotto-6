package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.validator.LottoNumberValidator;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private static final String NUMBERS_DELIMITER = ",";
    private final List<Integer> numbers;

    private WinningNumbers(String input) {
        this.numbers = validate(input);
    }

    public static WinningNumbers create(String winningNumbersInput) {
        return new WinningNumbers(winningNumbersInput);
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

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private List<Integer> validate(String input) {
        validateBlank(input);
        validateStartsOrEndsWithDelimiter(input);
        List<Integer> numbers = parseWinningNumbersInput(input);
        LottoNumberValidator.validateDuplicate(numbers);
        LottoNumberValidator.validateSize(numbers);
        return numbers;
    }

    private List<Integer> parseWinningNumbersInput(String input) {
        return Arrays.stream(input.split(NUMBERS_DELIMITER))
                .map(this::safeParseInt)
                .toList();
    }

    private Integer safeParseInt(String input) {
        try {
            int number = Integer.parseInt(input);
            LottoNumberValidator.validateRange(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_NOT_NUMERIC.getMessage());
        }
    }
}
