package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.global.constant.exception.ExceptionMessage.NUMBERS_DUPLICATED;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberNotDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberNotDuplicate(List<Integer> numbers) {
        Set<Integer> numbersWithoutDuplicates = new HashSet<>(numbers);
        if(numbersWithoutDuplicates.size() != numbers.size()) {
            throw new IllegalArgumentException(NUMBERS_DUPLICATED.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
