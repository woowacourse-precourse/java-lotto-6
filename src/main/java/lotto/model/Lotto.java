package lotto.model;

import static lotto.Constraints.MAX_NUMBER;
import static lotto.Constraints.MIN_NUMBER;
import static lotto.Constraints.SIZE;

import java.util.List;
import lotto.model.exceptions.DuplicatedNumberException;
import lotto.model.exceptions.InvalidSizeException;
import lotto.model.exceptions.OutOfRangeNumberException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbersDuplicate(numbers);
        validateInRangeNumber(numbers);
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

    // 범위 밖 숫자 검증
    private void validateInRangeNumber(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number > MAX_NUMBER.getValue() || number < MIN_NUMBER.getValue())
                .forEach(number -> {
                    throw new OutOfRangeNumberException();
                });
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

    @Override
    public String toString() {
        return numbers.toString();
    }
}