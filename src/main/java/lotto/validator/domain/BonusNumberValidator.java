package lotto.validator.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCondition;
import lotto.validator.domain.exception.DomainExceptionMessage;
import lotto.validator.domain.exception.DomainIllegalArgumentException;

public class BonusNumberValidator {

    public static void validateBonusNumber(final Lotto lotto, final int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicates(lotto, bonusNumber);
    }

    private static void validateRange(final int bonusNumber) {
        if (LottoCondition.isNotInRange(bonusNumber)) {
            throw new DomainIllegalArgumentException(DomainExceptionMessage.OUT_OF_RANGE_NUMBER);
        }
    }

    private static void validateDuplicates(final Lotto lotto, final int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new DomainIllegalArgumentException(DomainExceptionMessage.DUPLICATES_BONUS_NUMBER);
        }
    }
}
