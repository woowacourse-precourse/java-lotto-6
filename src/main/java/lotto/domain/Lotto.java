package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateduplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public void validateduplication(List<Integer> numbers) {
        Set<Integer> duplicationNumbers = new HashSet<>(numbers);
        if (duplicationNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}