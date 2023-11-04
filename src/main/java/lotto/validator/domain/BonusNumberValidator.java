package lotto.validator.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCondition;
import lotto.validator.domain.exception.DomainExceptionMessage;

public class BonusNumberValidator {

    public static void validateBonusNumber(final Lotto lotto, final int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicates(lotto, bonusNumber);
    }

    private static void validateRange(final int bonusNumber) {
        if (LottoCondition.isNotInRange(bonusNumber)) {
            throw DomainExceptionMessage.OUT_OF_RANGE_NUMBER.create();
        }
    }

    private static void validateDuplicates(final Lotto lotto, final int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw DomainExceptionMessage.DUPLICATES_BONUS_NUMBER.create();
        }
    }
}
