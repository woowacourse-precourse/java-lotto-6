package lotto.exception;

import lotto.model.BonusNumber;
import java.util.List;

public class BonusException extends NumberException {

    public static BonusNumber bonusException(List<Integer> numbers, int bonus) throws IllegalArgumentException {
        numberRangeException(bonus);
        duplicateException(numbers, bonus);
        return new BonusNumber(bonus);
    }

}
