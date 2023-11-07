package lotto;

import java.util.List;

import static lotto.constant.message.Error.*;
import static lotto.constant.Number.*;

public class Winning extends Lotto {
    private int bonusNumber;

    public Winning(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonus(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonus(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE.getMessage());
        }

        if (bonusNumber < MIN.getRange() || bonusNumber > MAX.getRange()) {
            throw new IllegalArgumentException(BONUS_RANGE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
