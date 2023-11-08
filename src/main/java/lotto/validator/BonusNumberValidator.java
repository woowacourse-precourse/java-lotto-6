package lotto.validator;

import lotto.domain.Lotto;
import lotto.domain.enums.Message;

public class BonusNumberValidator extends Validator {
    public static void validate(final Lotto lotto, final int number) {
        validateRange(number);
        validateDuplicates(lotto, number);
    }

    private static void validateDuplicates(final Lotto lotto, final int number) {
        if (lotto.contains(number)) {
            throw Message.ERROR_DUPLICATE_BONUS_NUMBER.createException();
        }
    }
}