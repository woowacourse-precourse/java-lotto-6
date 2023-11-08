package lotto.validator;

import lotto.domain.Lotto;
import lotto.domain.constants.LottoConstraint;
import lotto.domain.message.ErrorMessage;

public class BonusNumberValidator extends Validator {
    public static void validate(final Lotto lotto, final int number) {
        validateRange(number);
        validateDuplicates(lotto, number);
    }

    private static void validateDuplicates(final Lotto lotto, final int number) {
        if (lotto.contains(number)) {
            throw ErrorMessage.DUPLICATES_BONUS_NUMBER.createException();
        }
    }
}
