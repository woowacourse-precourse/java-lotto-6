package lotto.validator;

import java.util.HashSet;
import java.util.Set;

import static lotto.constants.ExceptionMessage.*;
import static lotto.constants.LottoSetting.*;
import static lotto.constants.LottoValidationPattern.*;

public class WinningNumbersValidator implements Validator {

    @Override
    public void validate(String input) {
        validateInputFormat(input);
        String[] numbers = input.split(DELIMITER.pattern());
        Set<Integer> winningNumbers = parseAndValidateNumbers(numbers);
        validateNoDuplicates(winningNumbers);
    }

    private void validateInputFormat(String input) {
        if (!input.matches(WINNING_NUMBER_INPUT_FORMAT.pattern())) {
            throw new IllegalArgumentException(WINNING_NUMBERS_FORMAT_ERROR.message());
        }
    }

    private Set<Integer> parseAndValidateNumbers(String[] numbers) {
        Set<Integer> winningNumbers = new HashSet<>();
        for (String numberStr : numbers) {
            int number = parseNumber(numberStr);
            validateNumberRange(number);
            winningNumbers.add(number);
        }
        return winningNumbers;
    }

    private int parseNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR.message());
        }
    }

    private void validateNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER.value() || number > MAX_LOTTO_NUMBER.value()) {
            throw new IllegalArgumentException(WINNING_NUMBERS_RANGE_ERROR.message());
        }
    }

    private void validateNoDuplicates(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_SIZE.value()) {
            throw new IllegalArgumentException(WINNING_NUMBERS_DUPLICATE_ERROR.message());
        }
    }
}
