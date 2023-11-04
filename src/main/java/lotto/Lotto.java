package lotto;

import static lotto.LottoRule.MAXIMUM;
import static lotto.LottoRule.MINIMUM;
import static lotto.LottoRule.SIZE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateNumberInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberInRange(List<Integer> numbers) {
        if (isNotNumberInRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotNumberInRange(List<Integer> numbers) {
        return !numbers.stream().allMatch(number ->
                number >= MINIMUM.getValue() && number <= MAXIMUM.getValue());
    }
}
