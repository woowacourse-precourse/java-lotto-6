package lotto;

import static lotto.Constant.LOTTO_NUMBER_COUNT;
import static lotto.Constant.MAXIMUM_LOTTO_NUMBER;
import static lotto.Constant.MINIMUM_LOTTO_NUMBER;
import static lotto.ErrorMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.ErrorMessage.INVALID_LOTTO_SIZE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicated(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int matchCountWith(Lotto lotto) {
        return Math.toIntExact(numbers.stream()
                .filter(lotto::contains)
                .count());
    }
}
