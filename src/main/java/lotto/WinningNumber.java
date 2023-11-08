package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private static final int WINNING_NUMBER_SIZE = 6;

    private final List<Integer> numbers;
    private final int bonus;

    public WinningNumber(List<Integer> numbers, int bonus) {
        validate(numbers,bonus);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonus() {
        return bonus;
    }

    private void validate(List<Integer> numbers, int bonus) {
        validateWinningNumberSize(numbers.size());
        validateDuplicatedNumbers(numbers);
        validateDuplicatedBonus(numbers,bonus);
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        Set<Integer> isNotDuplicatedNumbers = new HashSet<>(numbers);
        if (isNotDuplicatedNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException(Error.ERROR_MSG_DUPLICATED_NUMBERS.getMessage());
        }
    }

    private void validateDuplicatedBonus(List<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(Error.ERROR_MSG_DUPLICATED_BONUS.getMessage());
        }
    }

    private void validateWinningNumberSize(int size) {
        if (size != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException(Error.ERROR_MSG_SIZE.getMessage());
        }
    }


}
