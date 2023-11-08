package domain;

import utility.Utility;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
        this.numbers = Utility.sortAscending(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> unique = new HashSet<Integer>();
        for (int number : numbers) {
            if (!unique.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 값이 있습니다.");
            }
        }

    }

    private void validateNumberRange(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
