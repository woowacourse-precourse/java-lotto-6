package lotto.model;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSixNumbers(numbers);
        validateDuplicateNumbers(numbers);
        numbers.sort(Integer::compareTo);
        this.numbers = numbers;
    }

    private static void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복되어서는 안됩니다.");
        }
    }

    private void validateSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개로 이루어져야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
