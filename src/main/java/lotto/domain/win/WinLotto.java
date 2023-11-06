package lotto.domain.win;

import lotto.domain.Lotto;
import lotto.validator.WinLottoValidator;

public class WinLotto {
    public static final int LOTTO_NUMBER_LENGTH = 6;
    private final Lotto lotto;

    private final Bonus bonus;

    public WinLotto(Lotto lotto, Bonus bonus) {
        WinLottoValidator.go(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public int isEqual(Lotto lotto) {
        int equalCount = 0;
        for (int i = 0; i < LOTTO_NUMBER_LENGTH; i++) {
            if (this.lotto.getLotto().contains(lotto.getLotto().get(i))) {
                equalCount++;
            }
        }
        return equalCount;
    }

    public int isBonus(Lotto lotto) {
        int bonusCount = 0;
        if (lotto.getLotto().contains(bonus.getBonusNumber())) {
            bonusCount++;
        }
        return bonusCount;
    }
}
