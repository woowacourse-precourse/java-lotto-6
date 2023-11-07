package lotto.dto;

import lotto.domain.Lotto;

public final class WinningLottoDTO extends DTO.Input {
    private Lotto lotto;
    private Integer bonus;

    public Lotto getLotto() {
        return lotto;
    }

    public void setLotto(Lotto lotto) {
        validateOverride(this.lotto);
        this.lotto = lotto;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
}
