package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String DELIMITER = ",";
    private final InputValidator inputValidator;

    public InputParser() {
        this.inputValidator = new InputValidator();
    }

    public List<Integer> parseAndValidateWinningNumbers(String input) {
        List<Integer> parsedNumbers = parseNumbers(input);
        validateNumbers(parsedNumbers);
        return parsedNumbers;
    }

    public List<Integer> parseNumbers(String input) {
        String[] numbers = input.split(DELIMITER);
        return Arrays.stream(numbers)
                .map(String::trim)
                .map(this::convertToInt)
                .toList();
    }

    private Integer convertToInt(String number) {
        return inputValidator.validateNonNumeric(number);
    }

    private void validateNumbers(List<Integer> parsedNumbers) {
        inputValidator.validateNumberRange(parsedNumbers);
        inputValidator.validateDuplicateNumbers(parsedNumbers);
        inputValidator.validateWinningNumbersCount(parsedNumbers);
    }
}
