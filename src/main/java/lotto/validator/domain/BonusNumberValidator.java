package lotto.validator.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCondition;

public class BonusNumberValidator {

    private static final String DUPLICATES_BONUS_NUMBER = "[ERROR] 당첨 번호와 중복된 보너스 번호를 입력할 수 없습니다.";
    private static final String OUT_OF_RANGE_NUMBER = "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.";

    public static void validateBonusNumber(final Lotto lotto, final int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicates(lotto, bonusNumber);
    }

    private static void validateRange(final int bonusNumber) {
        if (LottoCondition.isNotInRange(bonusNumber)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER);
        }
    }

    private static void validateDuplicates(final Lotto lotto, final int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATES_BONUS_NUMBER);
        }
    }
}
