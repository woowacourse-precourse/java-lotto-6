package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private static final String DELIMITER = ",";
    private final InputValidator inputValidator;

    public InputParser() {
        this.inputValidator = new InputValidator();
    }

    public int validatePurchaseAmount(String input) {
        int money = inputValidator.validateNonNumeric(input);
        inputValidator.validatePurchaseAmount(money);
        return money;
    }

    public List<Integer> parseAndValidateWinningNumbers(String input) {
        List<Integer> parsedNumbers = parseNumbers(input);
        validateWinningNumbers(parsedNumbers);
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

    private void validateWinningNumbers(List<Integer> parsedNumbers) {
        inputValidator.validateNumberRange(parsedNumbers);
        inputValidator.validateDuplicateNumbers(parsedNumbers);
        inputValidator.validateWinningNumbersCount(parsedNumbers);
    }

    public int validateBonusNumber(String input) {
        int bonus = inputValidator.validateNonNumeric(input);
        inputValidator.validateNumberRange(List.of(bonus));
        return bonus;
    }
}
