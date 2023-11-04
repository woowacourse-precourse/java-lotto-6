package lotto.domain.lotto;

import static lotto.domain.lotto.Lotto.LOTTO_MAX_NUMBER;
import static lotto.domain.lotto.Lotto.LOTTO_MIN_NUMBER;

public class BonusNumber {
    private static final String BONUS_NUMBER_RANGE_ERROR = "보너스 번호는 1~45 이어야 합니다.";
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateBonusNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR);
        }
    }

    public boolean checkLottoContainBonusNumber(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }
}
