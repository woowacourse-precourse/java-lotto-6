package lotto.domain;

import lotto.util.LottoConstants;

import java.util.List;

public class WinningNumber {
    List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (checkNumbersCount(numbers) || hasDuplicates(numbers) || hasOutOfRangeNumbers(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkNumbersCount(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean hasOutOfRangeNumbers(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < LottoConstants.MIN_LOTTO_NUMBER.getValue() || number > LottoConstants.MAX_LOTTO_NUMBER.getValue());
    }
}
