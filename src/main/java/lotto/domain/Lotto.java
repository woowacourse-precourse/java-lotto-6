package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.message.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortAscending(numbers);
        this.numbers = Collections.unmodifiableList(numbers);
    }

    private void sortAscending(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }

    private void validate(List<Integer> numbers) {
        if (!hasCorrectSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage("6"));
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_EXIST.getMessage());
        }
        if (!hasCorrectRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private boolean hasCorrectSize(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> numbersWithoutDuplicate = new HashSet<>(numbers);

        return numbersWithoutDuplicate.size() != numbers.size();
    }

    private boolean hasCorrectRange(List<Integer> numbers) {
        return numbers.stream().noneMatch(number -> number < 1 || number > 45);
    }

    public void printNumbers() {
        System.out.println(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
