package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> checker = new HashSet<>();
        for (int i : numbers) {
            if (checker.contains(i)) {
                throw new IllegalArgumentException();
            }
            checker.add(i);
        }
    }

    public boolean hasNum(int num) {
        return numbers.contains(num);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    // TODO: 추가 기능 구현
}
