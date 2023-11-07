package lotto.model;

import lotto.view.ExceptionMessage;

import java.util.Comparator;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted(Comparator.comparing(Integer::intValue))
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.ONLY_SIZE_IS_SIX);
        }

        if(isDuplicated(numbers)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_DUPLICATE);
        }

        if (isZeroOrMinus(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_MINUS_OR_ZERO);
        }
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
