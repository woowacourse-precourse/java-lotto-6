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
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정확히 6개여야 합니다.");
        }

        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 값이 있습니다.");
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45 사이의 숫자여야 합니다.");
            }
        }
    }
    public String toString() {
        return numbers.toString();
    }

    // TODO: 추가 기능 구현
}
