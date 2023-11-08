package lotto.domain.win;

import static lotto.option.GameOption.LOTTO_NUMBER_LENGTH;

import lotto.domain.Lotto;
import lotto.validator.WinLottoValidator;

public record WinLotto(Lotto lotto, Bonus bonus) {
    public WinLotto {
        WinLottoValidator.check(lotto, bonus);
    }

    public int countEqual(Lotto lotto) {
        int equalCount = 0;
        for (int i = 0; i < LOTTO_NUMBER_LENGTH.getNumber(); i++) {
            if (this.lotto.numbers().contains(lotto.numbers().get(i))) {
                equalCount++;
            }
        }
        return equalCount;
    }

    public int countBonus(Lotto lotto) {
        int bonusCount = 0;
        if (lotto.numbers().contains(bonus.number())) {
            bonusCount++;
        }
        return bonusCount;
    }
}
