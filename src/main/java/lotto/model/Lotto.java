package lotto.model;

import lotto.exception.InvalidDuplicateNumberException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueItems = new HashSet<>();
        List<Integer> duplicates = numbers.stream()
                .filter(item -> !uniqueItems.add(item))
                .toList();
        if (duplicates.size() > 0) {
            throw new InvalidDuplicateNumberException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
