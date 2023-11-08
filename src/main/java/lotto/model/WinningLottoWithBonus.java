package lotto.model;

import lotto.validate.WinningLottoWithBonusValidate;

public class WinningLottoWithBonus {

    private final Lotto lotto;
    private final int bonus;

    public WinningLottoWithBonus(Lotto lotto, int bonus) {
        WinningLottoWithBonusValidate.valid(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }

}
