package lottoWinningNumber;

import static constant.ErrorMessage.DUPLICATE_VALUES_MESSAGE;
import static constant.ErrorMessage.INVALID_NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT);
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() < numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_VALUES_MESSAGE);
        }
    }
}