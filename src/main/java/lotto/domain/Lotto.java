package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;
import lotto.constant.Number;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkOverlap(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Number.SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.COUNT.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private void checkOverlap(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.OVERLAP.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
