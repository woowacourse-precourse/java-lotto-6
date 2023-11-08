package lotto.dto;

import lotto.domain.Lotto;

public final class WinningLottoInputDto extends InputDto {
    private Lotto lotto;
    private Integer bonus;

    public Lotto getLotto() {
        return lotto;
    }

    public void setLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
}
