package lotto;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.TOTAL_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_WINNING_NUMBER.getMessage());
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

    public void addBonusNumber(Integer bonusNumber) {
        validateBonusRange(bonusNumber);
        validateBonusDuplicate(bonusNumber);
        numbers.add(bonusNumber);
    }

    private void validateBonusRange(Integer bonusNumber) {
        if (bonusNumber < LottoConfig.MIN_LOTTO_NUMBER.getValue() || bonusNumber > LottoConfig.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_RANGE_NUMBER.getMessage());
        }
    }

    private void validateBonusDuplicate(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public boolean isContain(Integer number) {
        return numbers.contains(number);
    }

    public boolean isBonusContain(Integer number) {
        return numbers.get(LottoConfig.BONUS_POSITION.getValue()).equals(number);
    }
}
