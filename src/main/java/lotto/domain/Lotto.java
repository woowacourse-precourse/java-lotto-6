package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isLottoNumberNotDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void isLottoNumberNotDuplication(List<Integer> numbers) {
        Set<Integer> duplicationCheck = new HashSet<>(numbers);
        if (duplicationCheck.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int size() {
        return numbers.size();
    }

    public int get(int index) {
        return numbers.get(index);
    }

    public boolean contains(int value) {
        return numbers.contains(value);
    }
}
