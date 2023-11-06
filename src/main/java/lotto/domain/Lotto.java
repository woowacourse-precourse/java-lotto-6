package lotto.domain;

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
        if (!isSixNumbers(numbers)) {
            throw new IllegalArgumentException();
        } else if (!isInLottoRange(numbers)) {
            throw new IllegalArgumentException();
        } else if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isSixNumbers(final List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean isInLottoRange(final List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDuplicateNumbers(final List<Integer> numbers) {
        Set<Integer> numbersUnique = new HashSet<>(numbers);
        return numbersUnique.size() != numbers.size();
    }
}
