package lotto;

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

        if (isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicateNumber(List<Integer> numbers) {
        List<Integer> removedDuplicateNumbers = numbers.stream()
                .distinct()
                .toList();

        return numbers.size() != removedDuplicateNumbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int countBonusMatch(Integer bonus) {
        if (this.numbers.contains(bonus)) {
            return 1;
        }

        return 0;
    }

    public int countWinningNumbers(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(this.numbers::contains)
                .count();
    }
}
