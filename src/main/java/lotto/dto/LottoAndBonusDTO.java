package lotto.dto;

import lotto.model.Bonus;
import lotto.model.Lotto;

public class LottoAndBonusDTO {
    private final Lotto lotto;
    private final Bonus bonus;

    public LottoAndBonusDTO(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Bonus getBonus() {
        return bonus;
    }
}
