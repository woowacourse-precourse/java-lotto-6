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
