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
        validateUnique(numbers);
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int element : numbers) {
            if (!uniqueNumbers.add(element)) {
                throw new IllegalArgumentException("중복된 원소가 존재합니다.");
            }
        }
    }

    public int countMatch(List<Integer> targetNumbers) {
        int countNumberMatching = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (targetNumbers.get(i) == numbers.get(i))
                countNumberMatching++;
        }
        return countNumberMatching;
    }
}
