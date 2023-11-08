package lotto.domain;

import java.util.HashSet;
import java.util.List;

import static lotto.Error.Domain.*;

public final class Lotto {
    static final int LOTTO_LENGTH = 6;
    static final int MIN_LOTTO_NUMBER_SIZE = 1;
    static final int MAX_LOTTO_NUMBER_SIZE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCorrectLength(numbers);
        validateLottoNumber(numbers);
        validateDuplicatedNumber(numbers);
    }

    private void validateCorrectLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(WRONG_LOTTO_SIZE.getText());
        }
    }

    private void validateLottoNumber(List<Integer> numbers) {
        boolean isMatch = numbers.stream().allMatch(e -> MIN_LOTTO_NUMBER_SIZE <= e && e <= MAX_LOTTO_NUMBER_SIZE);
        if (!isMatch) {
            throw new IllegalArgumentException(WRONG_LOTTO_NUMBER_RANGE.getText());
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        int distinctSize = new HashSet<>(numbers).size();

        if (distinctSize != numbers.size()) {
            throw new IllegalArgumentException(SAME_LOTTO_NUMBER.getText());
        }
    }
}
