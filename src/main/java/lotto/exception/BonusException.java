package lotto.exception;

import lotto.model.BonusNumber;
import lotto.model.Number;

import java.util.List;

import static lotto.view.ErrorMessage.duplicatedBonusNumber;

public class BonusException extends CommonException {

    public static BonusNumber bonusException(List<Integer> numbers, int bonus) throws IllegalArgumentException {
        try {
            checkNumberException(bonus);
            bonusDuplicateException(numbers, bonus);
            return new BonusNumber(bonus);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void bonusDuplicateException(List<Integer> numbers, int bonus) throws IllegalArgumentException {
        try {
            Number.checkDuplicate(numbers, bonus);
        } catch (IllegalArgumentException e) {
            duplicatedBonusNumber();
            throw new IllegalArgumentException();
        }
    }
}
