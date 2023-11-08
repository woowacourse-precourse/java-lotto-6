package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumbers(numbers);
        validateOutRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers){
        if (numbers.stream()
                .distinct()
                .toList()
                .size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    private void validateOutRange(List<Integer> numbers){
        numbers.stream()
                .filter(number -> number < 1 || number > 45)
                .findAny()
                .ifPresent(outRangeNumber -> {
                    throw new IllegalArgumentException();
        });
    }
}
