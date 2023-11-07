package lotto.Model;

import static lotto.Model.GenerateNumbers.LOTTO_SIZE;
import static lotto.Model.GenerateNumbers.MAX_RANGE;
import static lotto.Model.GenerateNumbers.MIN_RANGE;
import static lotto.View.SystemMessage.ERROR_INVALID_COUNT;
import static lotto.View.SystemMessage.ERROR_INVALID_RANGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicate(numbers);
        isInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE)
            throw new IllegalArgumentException(ERROR_INVALID_COUNT.getMessage());
    }

    private void isDuplicate(List<Integer> numbers) {
        Set<Integer> reMoveDuplicate = new HashSet<Integer>(numbers);

        if (reMoveDuplicate.size() != numbers.size())
            throw new IllegalArgumentException(ERROR_INVALID_COUNT.getMessage());
    }

    private void isInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > MAX_RANGE || number < MIN_RANGE)
                throw new IllegalArgumentException(ERROR_INVALID_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
