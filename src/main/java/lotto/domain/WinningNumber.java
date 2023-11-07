package lotto.domain;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoGameException;
import lotto.util.LottoConstants;

import java.util.List;

public class WinningNumber {
    private List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (checkNumbersCount(numbers)) {
            throw new LottoGameException(ErrorMessage.INVALID_INTEGER_COUNT);
        }
        if (hasDuplicates(numbers)) {
            throw new LottoGameException(ErrorMessage.DUPLICATE_INPUT);
        }
        if (hasOutOfRangeNumbers(numbers)) {
            throw new LottoGameException(ErrorMessage.OUT_OF_RANGE);
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

    public List<Integer> getNumbers() {
        return numbers;
    }
}
