package lotto.domain.lottoTicket;

import lotto.domain.exception.lottoException.LottoNumberRangeException;
import lotto.utils.NumberUtils;

public record BonusNumber(int bonusNumber) {

    public static BonusNumber from(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        return new BonusNumber(bonusNumber);
    }

    private static void validateBonusNumber(int bonusNumber) {
        if (NumberUtils.isNotInRange(Lotto.START_INCLUSIVE, Lotto.END_INCLUSIVE, bonusNumber)) {
            throw new LottoNumberRangeException();
        }
    }
}
