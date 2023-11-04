package lotto;

public class LottoDrawResult {
    private Lotto lotto;
    private Integer bonus;

    public LottoDrawResult(Lotto lotto, Integer bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Integer getBonus() {
        return bonus;
    }
}
