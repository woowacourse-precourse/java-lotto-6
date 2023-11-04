package lotto.domain;

import lotto.message.ExceptionMessage;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number > 45 || number < 0)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_OVER_RANGE.toString());
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ExceptionMessage.IS_DUPLICATED.toString());
        }
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_6_LENGTH_OF_WINNING.toString());
        }
    }
}
