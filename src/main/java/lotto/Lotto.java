package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.TOTAL_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoConfig.TOTAL_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < LottoConfig.MIN_LOTTO_NUMBER.getValue() || n > LottoConfig.MAX_LOTTO_NUMBER.getValue())) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_RANGE_NUMBER.getMessage());
        }
    }

    public int getCalculateResult(WinningNumber winningNumber) {
        return (int) numbers.stream().filter(winningNumber::isContain).count();
    }

    public boolean isBonusNumberIn(WinningNumber winningNumber) {
        return numbers.stream().anyMatch(winningNumber::isBonusContain);
    }
    @Override
    public String toString() {
        return numbers.toString();
    }
}
