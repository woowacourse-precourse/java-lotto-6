package lotto.exception;

import lotto.model.BonusNumber;

import java.util.List;

import static lotto.exception.NumberCheck.checkDuplicate;
import static lotto.view.ErrorMessage.duplicatedBonusNumber;

public class BonusException extends NumberException {

    public static BonusNumber bonusException(List<Integer> numbers, int bonus) throws IllegalArgumentException {
        numberRangeException(bonus);
        if (!checkDuplicate(numbers, bonus)) {
            duplicatedBonusNumber();
            throw new IllegalArgumentException();
        }
        return new BonusNumber(bonus);
    }

}
