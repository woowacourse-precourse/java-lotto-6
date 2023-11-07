package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkLottoNumbersRange(numbers);
        checkDuplicateNumber(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateNumber(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        uniqueNumbers.addAll(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있으면 안됩니다.");
        }
    }

    private void checkLottoNumbersRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number > MAX_NUMBER_RANGE || number < MIN_NUMBER_RANGE)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException("각 숫자는 1과 45사이여야 합니다.");
                });
    }

    public boolean isContain(int number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }

    public int countSameNumber(Lotto other) {
        return (int)numbers.stream()
                .filter(other.numbers::contains)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
