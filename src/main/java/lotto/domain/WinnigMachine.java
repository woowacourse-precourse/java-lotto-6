package lotto.domain;

import static lotto.utils.ConstantValues.MAX_LOTTO_NUMBER;
import static lotto.utils.ConstantValues.MIN_LOTTO_NUMBER;
import static lotto.utils.ErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.utils.ErrorMessages.WINNING_NUMBERS_CONTAINS_BONUS_NUMBER;

public class WinnigMachine {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinnigMachine(Lotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateWinningLottoNotContainsBonusNumber(winningLotto, bonusNumber);
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(LOTTO_NUMBER_OUT_OF_RANGE, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
    }

    private void validateWinningLottoNotContainsBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_CONTAINS_BONUS_NUMBER);
        }
    }

    public Prize getPrize(Lotto lotto) {
        int sameCount = lotto.getSameCount(winningLotto);
        boolean hasBonusNumber = lotto.hasNumber(bonusNumber);
        return Prize.getPrize(sameCount, hasBonusNumber);
    }
}
