package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.Numbers;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicatedNumbers(numbers);
        checkNumberInRange(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != Numbers.VALID_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT);
        }
    }

    private void checkDuplicatedNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATED_NUMBER);
        }
    }

    private void checkNumberInRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < Numbers.RANGE_MIN_NUMBER || number > Numbers.RANGE_MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
            }
        });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
