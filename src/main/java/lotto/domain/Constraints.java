package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public interface Constraints {

    Integer NUMBER_LENGTH = 6;
    Integer MAX = 45;
    Integer MIN = 0;

    default void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != NUMBER_LENGTH
                || numbers.stream().anyMatch(value -> value < MIN)
                || numbers.stream().anyMatch(value -> value > MAX)
                || hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 중복되지 않는 숫자여야 합니다.");
        }
    }

    private boolean hasDuplicateNumber(List<Integer> numbers) {
        List<Integer> distinctValues = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        return distinctValues.size() < numbers.size();
    }
}
