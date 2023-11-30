package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicated(numbers);
    }


    private static void validateDuplicated(List<Integer> numbers) {
        HashSet<Integer> numbersWithoutDuplicated = new HashSet<>(numbers);
        if (numbers.size() != numbersWithoutDuplicated.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복되는 숫자가 없어야 합니다.");
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <= 0 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1 에서 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리 숫자여야 합니다.");
        }
    }
}
