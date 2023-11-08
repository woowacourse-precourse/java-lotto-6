package lotto.model;

import lotto.exception.ExceptionMessage;

import java.util.Comparator;
import java.util.List;

import static lotto.validator.Validator.validateCondition;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted(Comparator.comparing(Integer::intValue))
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateCondition(!isSizeSix(numbers), ExceptionMessage.ONLY_SIZE_IS_SIX);
        validateCondition(isDuplicated(numbers), ExceptionMessage.NOT_DUPLICATE);
        validateCondition(isZeroOrMinus(numbers), ExceptionMessage.NOT_MINUS_OR_ZERO);
    }

    private boolean isSizeSix(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean isZeroOrMinus(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number <= 0);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<String> getNumbersForString() {
        return numbers.stream()
                .map(String::valueOf)
                .toList();
    }

}
