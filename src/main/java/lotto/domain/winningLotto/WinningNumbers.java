package lotto.domain.winningLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;
import lotto.domain.Lotto;

public class WinningNumbers {

    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_SIZE.getMessage()
                    .formatted(LottoConstants.LOTTO_NUMBERS_SIZE.getValue()));
        }
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != LottoConstants.LOTTO_NUMBERS_SIZE.getValue();
    }

    private void validateRange(List<Integer> numbers) {
        long numbersSizeWithValidRange = getNumbersSizeWithValidRange(numbers);
        if (numbers.size() != numbersSizeWithValidRange) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.getMessage()
                    .formatted(
                            LottoConstants.MIN_LOTTO_NUMBER.getValue(),
                            LottoConstants.MAX_LOTTO_NUMBER.getValue()
                    )
            );
        }
    }

    private long getNumbersSizeWithValidRange(List<Integer> numbers) {
        return numbers.stream()
                .filter(this::isValidRange)
                .count();
    }

    private boolean isValidRange(int number) {
        return isGreaterThanMinimum(number) && isLessThanMaximum(number);
    }

    private boolean isGreaterThanMinimum(int number) {
        return LottoConstants.MIN_LOTTO_NUMBER.getValue() <= number;
    }

    private boolean isLessThanMaximum(int number) {
        return number <= LottoConstants.MAX_LOTTO_NUMBER.getValue();
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_WINNING_NUMBER.getMessage());
        }
    }

    public long matchCount(Lotto lotto) {
        return numbers.stream()
                .filter(lotto::contains)
                .count();
    }
}
