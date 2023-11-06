package lotto.domain;

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
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> notDuplicate = new HashSet<>(numbers);
        if (notDuplicate.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }
}
