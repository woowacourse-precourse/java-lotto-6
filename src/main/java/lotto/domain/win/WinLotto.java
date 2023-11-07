package lotto.domain.win;

import static lotto.Option.GameOption.LOTTO_NUMBER_LENGTH;

import lotto.domain.Lotto;
import lotto.validator.WinLottoValidator;

public class WinLotto {
    private final Lotto lotto;

    private final Bonus bonus;

    public WinLotto(Lotto lotto, Bonus bonus) {
        WinLottoValidator.check(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public int isEqual(Lotto lotto) {
        int equalCount = 0;
        for (int i = 0; i < LOTTO_NUMBER_LENGTH.getNumber(); i++) {
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
