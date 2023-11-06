package lotto.domain;

import static lotto.ErrorMessage.BONUS_DUPLICATION_ERROR_MESSAGE;

public class WiningLottoNumbers {
    private final Lotto winingLotto;
    private final Bonus bonus;

    public WiningLottoNumbers(Lotto winingLotto, Bonus bonus) {
        validate(winingLotto, bonus);
        this.winingLotto = winingLotto;
        this.bonus = bonus;
    }

    public int countWining(Lotto lotto) {
        int result = 0;
        if (isWiningBonus(lotto)) {
            result += 1;
        }
        result += winingLotto.countMatching(lotto);
        return result;
    }

    public boolean isWiningBonus(Lotto lotto) {
        return lotto.hasNumber(bonus.get());
    }

    private void validate(Lotto lotto, Bonus bonus) {
        if (hasBonusNumberInLotto(lotto, bonus)) {
            throwException(BONUS_DUPLICATION_ERROR_MESSAGE.get());
        }
    }

    private boolean hasBonusNumberInLotto(Lotto lotto, Bonus bonus) {
        return lotto.hasNumber(bonus.get());
    }

    private void throwException(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
