package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static lotto.message.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_SIZE_EXCEPTION.getMessage());
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(NOT_UNIQUE_EXCEPTION.getMessage());
        }
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(NOT_IN_RANGE_EXCEPTION.getMessage());
        }
        if (!isSorted(numbers)) {
            throw new IllegalArgumentException(NOT_SORTED_EXCEPTION.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public int calculateMatchNumber(UserLotto userLotto) {
        return (int) userLotto.getLottoNumber().stream()
                .filter(number -> numbers.contains(number))
                .count();
    }

    public boolean calculateBonusNumber(UserLotto userLotto) {
        return numbers.contains(userLotto.getBonusNumber());
    }

    private boolean isSorted(List<Integer> numbers) {
        return IntStream.range(1, numbers.size())
                .allMatch(i -> numbers.get(i) >= numbers.get(i - 1));
    }
}
