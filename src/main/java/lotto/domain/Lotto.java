package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.constant.ExceptionMessage;
import lotto.constant.NumberRange;

public class Lotto {

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
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBER.getMessage());
        }
    }

    private void checkLottoNumbersRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number > NumberRange.MAX_NUMBER.getNumber() ||
                        number < NumberRange.MIN_NUMBER.getNumber())
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(ExceptionMessage.OVER_NUMBER_RANGE.getMessage());
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
