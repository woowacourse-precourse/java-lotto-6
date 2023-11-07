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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int calcMatchNumber(List<Integer> numbersToCompare) {
        Set<Integer> winningNumbers = new HashSet<>(numbersToCompare);
        int matchCount = 0;

        for(int number: numbers) {
            if (winningNumbers.contains(number)) {
                matchCount += 1;
            }
        }

        return matchCount;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
