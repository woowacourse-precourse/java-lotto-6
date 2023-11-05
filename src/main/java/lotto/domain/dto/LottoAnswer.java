package lotto.domain.dto;

public class LottoAnswer {
    private final LottoNumbers lotto;
    private final int bonus;

    public LottoAnswer(LottoNumbers lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }
}
