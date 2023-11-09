package lotto.util.validator;

import static lotto.util.Constant.*;
import static lotto.util.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersValidator extends Validator {

    public void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    public static NumbersValidator createValidator() {
        return new NumbersValidator();
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_PICK_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
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
