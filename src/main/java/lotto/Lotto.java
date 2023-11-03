package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리여야 합니다.");
        }
    }

    private void duplicate(List<Integer> numbers) {
        Set<Integer> num = new HashSet<>(numbers);
        if (num.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }
    }
}
