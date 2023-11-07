package lotto.model;

import static lotto.Constraints.SIZE;

import java.util.List;
import lotto.model.exceptions.DuplicatedNumberException;
import lotto.model.exceptions.InvalidSizeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbersDuplicate(numbers);
    }

    // 6자리 검증
    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE.getValue()) {
            throw new InvalidSizeException();
        }
    }

    // 중복된 숫자 검증
    private void validateNumbersDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != SIZE.getValue()) {
            throw new DuplicatedNumberException();
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int calculateSameNumberCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}