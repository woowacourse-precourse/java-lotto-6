package lotto.validator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbersRule;

public final class WinningLottoValidator {

    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1 ~ 45 숫자만 가능합니다.";
    private static final String DUPLICATION_ERROR_MESSAGE = "[ERROR] 당첨 번호에 이미 존재하는 숫자입니다.";

    private WinningLottoValidator() {
    }

    public static void validate(final int bonusNumber, final Lotto winningLotto) {
        validateBonusNumberRange(bonusNumber);
        validateDuplication(bonusNumber, winningLotto);
    }

    private static void validateBonusNumberRange(final int bonusNumber) {
        if (LottoNumbersRule.hasOutOfRangeNumber(bonusNumber)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private static void validateDuplication(final int bonusNumber, final Lotto winningLotto) {
        if (winningLotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

}
