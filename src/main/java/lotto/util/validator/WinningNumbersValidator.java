package lotto.util.validator;

import static lotto.util.Constant.*;
import static lotto.util.ErrorMessage.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbersValidator extends Validator {

    @Override
    public List<Integer> validate(String input) {
        validateNumber(input, WINNING_NUMBERS_PATTERN);
        List<Integer> numbers = Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt).toList();
        validateRange(numbers);
        validateDuplication(numbers);
        return numbers;
    }

    public static WinningNumbersValidator createValidator() {
        return new WinningNumbersValidator();
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateDuplication(List<Integer> inputNumbers) {
        Set<Integer> validateNumbers = new HashSet<>(inputNumbers);
        if (validateNumbers.size() < NUMBER_PICK_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }
}
