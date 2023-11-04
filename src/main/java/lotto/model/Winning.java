package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.Code;
import lotto.utils.Message;

public class Winning extends Lotto{
    private final List<Integer> numbers;
    private final int bonusNumber;

    public Winning(List<Integer> numbers, int bonusNumber) {
        super(numbers);

        numbers.forEach(number -> validateNumberInRange(number, Code.WINNING.getCode()));
        this.numbers = numbers;

        validateDuplicatedWinningAndBonus(numbers, bonusNumber);
        validateNumberInRange(bonusNumber, Code.BONUS.getCode());
        this.bonusNumber = bonusNumber;
    }

    private void validateNumberInRange(int number, String code) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(code + Message.NUMBER_NOT_INRANGE.getMessage());
        }
    }

    private void validateDuplicatedWinningAndBonus(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.NOT_DUPLICATED.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
