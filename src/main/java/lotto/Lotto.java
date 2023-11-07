package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해 주세요.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력해 주세요.");
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> deduplicateNumber = new HashSet<>(numbers);
        if (deduplicateNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 입력해 주세요.");
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
