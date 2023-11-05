package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.util.ErrorMessages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.NOT_SIX_NUMBER_ERROR.getMessage());
        }

        if (isContainSameNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBER_ERROR.getMessage());
        }
    }

    private boolean isContainSameNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return numbers.size() != set.size();
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[",  "]"));
    }
}
