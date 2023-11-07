package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    private void checkDuplication(List<Integer> numbers) {
        Set<Integer> noDuplicationNumbers = new HashSet<>(numbers);
        if (numbers.size() != noDuplicationNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 번호는 중복되지 않는 숫자여야 합니다.");
        }
    }

    public int countEqualNumber(List<Integer> numbers) {
        List<Integer> originalNumbers = new ArrayList<>(this.numbers);
        originalNumbers.retainAll(numbers);
        return originalNumbers.size();
    }

    public boolean contain(Integer number) {
        return this.numbers.contains(number);
    }
}
