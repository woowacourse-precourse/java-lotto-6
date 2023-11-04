package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (isContainSameNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isContainSameNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return numbers.size() != set.size();
    }

    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[",  "]"));
    }
}
