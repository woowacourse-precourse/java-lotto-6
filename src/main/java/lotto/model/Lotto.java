package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getLotto() {
        return numbers;
    }

    public void checkDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if (uniqueNumber.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> sortLottoByASCE(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

}

