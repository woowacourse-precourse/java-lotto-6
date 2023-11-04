package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.Code;
import lotto.utils.Message;

public class Winning {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public Winning(List<Integer> numbers, int bonusNumber) {
        validateNumberCount(numbers);
        validateDuplicatedNumber(numbers);
        numbers.forEach(number -> validateNumberInRange(number, Code.WINNING.getCode()));
        this.numbers = numbers;

        validateDuplicatedWinningAndBonus(numbers, bonusNumber);
        validateNumberInRange(bonusNumber, Code.BONUS.getCode());
        this.bonusNumber = bonusNumber;
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.LACK_NUMBER_COUNT.getMessage());
        }
    }

    private void validateNumberInRange(int number, String code) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(code + Message.NUMBER_NOT_INRANGE.getMessage());
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(Message.NOT_DUPLICATED.getMessage());
        }
    }

    private void validateDuplicatedWinningAndBonus(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.NOT_DUPLICATED.getMessage());
        }
    }
}
