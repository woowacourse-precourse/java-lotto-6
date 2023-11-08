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

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> numSet = new HashSet<Integer>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되어서는 안 됩니다.");
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 총 6객의 숫자를 입력해야 합니다.");
        }
        for (int num : numbers) {
            if (num < 1 | num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}