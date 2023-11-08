package lotto.domain.lotto;

import java.util.List;

import static lotto.io.ErrorMessage.*;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getLottoSize() {
        return numbers.size();
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoInRange(numbers);
        validateLottoUnique(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE.getMessage());
        }
    }

    private void validateLottoInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER) {
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    private void validateLottoUnique(List<Integer> numbers) {
        long distinctNumberCount = numbers.stream()
                .distinct()
                .count();

        if (distinctNumberCount != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

}
