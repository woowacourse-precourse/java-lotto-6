package lotto.domain;

import static lotto.constant.ErrorMessage.NO_DUPLICATION_ALLOWED;
import static lotto.constant.ErrorMessage.WRONG_NORMAL_NUMBER_COUNT;
import static lotto.constant.ErrorMessage.WRONG_NUMBER_RANGE;
import static lotto.constant.GameNumber.MAX_NUMBER;
import static lotto.constant.GameNumber.MIN_NUMBER;
import static lotto.constant.GameNumber.NORMAL_NUMBER_COUNT;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateNumbers(numbers);
        validateDuplication(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != NORMAL_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(WRONG_NORMAL_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER.getNumber() || number > MAX_NUMBER.getNumber()) {
                throw new IllegalArgumentException(WRONG_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i != numbers.indexOf(numbers.get(i))) {
                throw new IllegalArgumentException(NO_DUPLICATION_ALLOWED.getMessage());
            }
        }
    }
}
