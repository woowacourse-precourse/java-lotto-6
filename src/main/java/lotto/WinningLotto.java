package lotto;

import static lotto.Lotto.LOTTO_MAX_NUMBER;
import static lotto.Lotto.LOTTO_MIN_NUMBER;

public class WinningLotto {
    private static final String NON_OVERLAPPING_NUMBER_REQUEST_MESSAGE = "보너스 번호는 당첨 번호와 겹치치 않아야 합니다.";
    private static final String CHECK_NUMBER_RANGE_REQUEST_MESSAGE = "보너스 번호는 1~45 사이의 숫자여야 합니다.";

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberNotOverlapWinningNumber(lotto, bonusNumber);

        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if ((bonusNumber < LOTTO_MIN_NUMBER) || (bonusNumber > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(CHECK_NUMBER_RANGE_REQUEST_MESSAGE);
        }
    }

    private void validateBonusNumberNotOverlapWinningNumber(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(NON_OVERLAPPING_NUMBER_REQUEST_MESSAGE);
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}