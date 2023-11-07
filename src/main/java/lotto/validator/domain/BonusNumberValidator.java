package lotto.validator.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCondition;
import lotto.validator.domain.exception.DomainExceptionMessage;

public class BonusNumberValidator {

    private BonusNumberValidator() {
    }

    public static void validateBonusNumber(final Lotto lotto, final int number) {
        validateRange(number);
        validateDuplicates(lotto, number);
    }

    private static void validateRange(final int number) {
        if (LottoCondition.isNotInRange(number)) {
            throw DomainExceptionMessage.OUT_OF_RANGE_NUMBER.create();
        }
    }

    private static void validateDuplicates(final Lotto lotto, final int number) {
        if (lotto.contains(number)) {
            throw DomainExceptionMessage.DUPLICATES_BONUS_NUMBER.create();
        }
    }
}
