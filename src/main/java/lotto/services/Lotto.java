package lotto.services;

import static lotto.exception.ExceptionHandler.numberInDuplicate;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);

        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicatedNumber(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();

        if (distinctCount != numbers.size()) {
            numberInDuplicate();
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }


}
