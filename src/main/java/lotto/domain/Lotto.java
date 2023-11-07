package lotto.domain;

import static lotto.constant.LottoInformation.MAX_NUMBER;
import static lotto.constant.LottoInformation.MIN_NUMBER;
import static lotto.constant.LottoInformation.NUMBER_COUNT;
import static lotto.constant.message.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.constant.message.ErrorMessage.INVALID_COUNT;
import static lotto.constant.message.ErrorMessage.INVALID_NUMBER_RANGE;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_COUNT.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (!numbers.stream().allMatch(this::isValidRange)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    private boolean isValidRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
