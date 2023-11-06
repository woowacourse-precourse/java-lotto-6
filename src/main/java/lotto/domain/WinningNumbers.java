package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> numbers;
    private final int BONUS_NUMBER;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        validate(numbers);
        validate(bonusNumber);
        this.numbers = numbers;
        this.BONUS_NUMBER = bonusNumber;
    }

    public int calculateWinningNumber(Lotto lotto){
        return lotto.getCorrectNumberCount(numbers);
    }

    public int calculateBonusNumber(Lotto lotto){
        return lotto.getCorrectNumberCount(BONUS_NUMBER);
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validate(int numbers) {
        validateRange(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
    }

    private void validateRange(List<Integer> numbers) {

    }

    private void validateRange(int numbers) {

    }
}
