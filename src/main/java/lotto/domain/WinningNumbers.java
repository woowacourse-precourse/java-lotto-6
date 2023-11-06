package lotto.domain;

import static common.ErrorCode.WINNING_NUMBERS_INVALID_SIZE;
import static java.util.stream.Collectors.toList;

import common.exception.InvalidArgumentException;
import java.util.List;

public class WinningNumbers {

    private static final int VALID_SIZE = 6;
    private final List<LottoNumber> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(toList());
    }

    private void validateNumbers(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            throw new InvalidArgumentException(WINNING_NUMBERS_INVALID_SIZE);
        }
    }

    private boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == VALID_SIZE;
    }
}
