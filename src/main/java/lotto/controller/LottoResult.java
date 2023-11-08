package lotto.controller;

import lotto.Lotto;

public class LottoResult {
    private final Lotto lotto;
    private final int bonusNumber;

    private LottoResult(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static LottoResult from(Lotto lotto, int bonusNumber) {
        return new LottoResult(lotto, bonusNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
