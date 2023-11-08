package lotto;

import static lotto.ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        duplicate();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicate() {
        boolean hasDuplicates = numbers.stream()
                .distinct()
                .count() < numbers.size();
        if (hasDuplicates) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}