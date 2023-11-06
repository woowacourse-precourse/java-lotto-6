package lotto.domain;

import java.util.List;
import lotto.util.Util;

public class Lotto extends Validation {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Util.sortListAscending(numbers);
    }

    private void validate(List<Integer> numbers) {
        checkNumbersLength(numbers);
        checkNumbersDuplicate(numbers);
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::isContainNumber)
                .count();
    }

    public boolean isContainNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
