package lotto.vailator;

import lotto.domain.Lotto;

import static lotto.util.ErrorMessage.BONUS_NUMBER_DUPLICATE_WITH_WIN_LOTTO;
import static lotto.util.ErrorMessage.LOTTO_NUMBER_RANGE_ERROR;
import static lotto.util.LottoNumber.END_LOTTO_NUMBER;
import static lotto.util.LottoNumber.START_LOTTO_NUMBER;

public class WinningLottoValidator {
    private boolean isNotInRange(int bonusNum) {
        return bonusNum < START_LOTTO_NUMBER.getValue() || bonusNum > END_LOTTO_NUMBER.getValue();
    }

    public void checkRange(int bonusNum) {
        if (isNotInRange(bonusNum)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR.getErrorMessage());
        }
    }

    private boolean isDuplicateWinningNumbers(Lotto winLotto, int bonusNum) {
        return winLotto.hasSameNumber(bonusNum);
    }

    public void checkDuplicateWinningNumbers(Lotto winLotto, int bonusNum) {
        if (isDuplicateWinningNumbers(winLotto, bonusNum)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_WITH_WIN_LOTTO.getErrorMessage());
        }
    }
}
