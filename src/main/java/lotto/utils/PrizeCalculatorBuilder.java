package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.service.PrizeCalculator;

public class PrizeCalculatorBuilder {
    private Lottos lottos;

    private Lotto prizeLotto;

    private int bonusNumber;

    public PrizeCalculatorBuilder lottos(Lottos lottos) {
        this.lottos = lottos;
        return this;
    }

    public PrizeCalculatorBuilder prizeLotto(Lotto prizeLotto) {
        this.prizeLotto = prizeLotto;
        return this;
    }

    public PrizeCalculatorBuilder bonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
        return this;
    }

    public PrizeCalculator build() {
        return new PrizeCalculator(prizeLotto, lottos, bonusNumber);
    }
}
