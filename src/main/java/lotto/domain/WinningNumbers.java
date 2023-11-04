package lotto.domain;

import lotto.exception.ErrorMessage;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static final String NUMBERS_DELIMITER = ",";
    private static final int NUMBERS_SIZE = 6;
    private static final int MINIMUM_RANGE = 1;
    private static final int MAXIMUM_RANGE = 45;

    private final List<Integer> numbers;

    private WinningNumbers(String input) {
        List<Integer> winningNumbers = validate(input);
        this.numbers = winningNumbers;
    }

    public static WinningNumbers create(String winningNumbersInput) {
        return new WinningNumbers(winningNumbersInput);
    }

    private List<Integer> validate(String input) {
        validateBlank(input);
        validateStartsOrEndsWithDelimiter(input);
        List<Integer> numbers = parseWinningNumbersInput(input);
        validateDuplicates(numbers);
        validateSize(numbers);
        return numbers;
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

    private List<Integer> parseWinningNumbersInput(String input) {
        return Arrays.stream(input.split(NUMBERS_DELIMITER))
                .map(this::safeParseInt)
                .filter(this::isValidRange)
                .toList();
    }

    private Integer safeParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_NOT_NUMERIC.getMessage());
        }
    }

    private boolean isValidRange(Integer number) {
        if (number < MINIMUM_RANGE || number > MAXIMUM_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_INVALID_RANGE.getMessage());
        }
        return true;
    }

    private static void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_DUPLICATED.getMessage());
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBERS_INVALID_SIZE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
