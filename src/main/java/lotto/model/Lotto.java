package lotto.model;

import static lotto.controller.GameConstants.LOTTO_NUMBER_SIZE;
import static lotto.controller.GameConstants.MAX_NUMBER;
import static lotto.controller.GameConstants.MIN_NUMBER;
import static lotto.message.ErrorMessage.DUPLICATE_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.OUT_OF_RANGE_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.UNAVAILABLE_LENGTH_ERROR_MESSAGE;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateHasSixSize(numbers);
        validateIsDuplicate(numbers);
        for (int number : numbers) {
            validateInRange(number);
        }
    }

    private void validateHasSixSize(List<Integer> input) {
        if (input.size() != LOTTO_NUMBER_SIZE.getNumber()) {
            throw new IllegalArgumentException(UNAVAILABLE_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateIsDuplicate(List<Integer> input) {
        long inputSize = input.size();
        long uniqueInputSize = input.stream()
                .distinct()
                .count();

        if (inputSize != uniqueInputSize) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateInRange(int input) {
        if (input < MIN_NUMBER.getNumber() || input > MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    public String getLottoNumbers() {
        Collections.sort(numbers);
        return numbers.toString();
    }

    public boolean contains(int input) {
        return numbers.contains(input);
    }

    public int countCorrectNumbers(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }
}
