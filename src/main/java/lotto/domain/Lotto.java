package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicate(numbers);
        checkRange(numbers);
        this.numbers = numbers;
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 개수를 6개로 맞춰 주세요.");
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> dupCheck = new HashSet<>(numbers);
        if (dupCheck.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 중 중복되는개 존재합니다.");
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (num > 45 || num <= 0)
                throw new IllegalArgumentException("[ERROR] 로또 번호를 0 - 45 사이로 정해 주세요.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
