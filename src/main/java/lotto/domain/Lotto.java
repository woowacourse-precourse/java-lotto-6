package lotto.domain;

import static lotto.constant.ErrorMessage.NO_DUPLICATION_ALLOWED;
import static lotto.constant.ErrorMessage.ONLY_NUMBERS_COMMA_ALLOWED;
import static lotto.constant.ErrorMessage.WRONG_NORMAL_NUMBER_COUNT;
import static lotto.constant.ErrorMessage.WRONG_NUMBER_RANGE;
import static lotto.constant.GameNumber.MAX_NUMBER;
import static lotto.constant.GameNumber.MIN_NUMBER;
import static lotto.constant.GameNumber.NORMAL_NUMBER_COUNT;

import java.util.Arrays;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Lotto(String input) {
        this.numbers = validateNumeric(input);
        validateCount();
        validateNumbers();
        validateDuplication();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private List<Integer> validateNumeric(String input) {
        try {
            return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBERS_COMMA_ALLOWED.getMessage());
        }
    }

    private void validateCount() {
        if (this.numbers.size() != NORMAL_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(WRONG_NORMAL_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNumbers() {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER.getNumber() || number > MAX_NUMBER.getNumber()) {
                throw new IllegalArgumentException(WRONG_NUMBER_RANGE.getMessage());
            }
        }
    }

    private void validateDuplication() {
        for (int i = 0; i < numbers.size(); i++) {
            if (i != numbers.indexOf(numbers.get(i))) {
                throw new IllegalArgumentException(NO_DUPLICATION_ALLOWED.getMessage());
            }
        }
    }
}
