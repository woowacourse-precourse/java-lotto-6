package lotto.model;

import static java.util.Arrays.stream;
import static lotto.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.ErrorMessage.ERROR_MESSAGE;
import static lotto.ErrorMessage.OVER_LOTTO_BOUNDARY;
import static lotto.ErrorMessage.OVER_LOTTO_SIZE;

import java.util.List;
import lotto.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateOverSize(numbers);
        validateDuplicateNumber(numbers);
        validateInRange(numbers);
    }

    private void validateOverSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getMessage()+OVER_LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        long distinctListSize = numbers.stream()
                .distinct()
                .count();
        if (distinctListSize != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getMessage()+DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateInRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ERROR_MESSAGE.getMessage()+OVER_LOTTO_BOUNDARY.getMessage());
            }
        });
    }
}
