package lotto.domain;

import java.util.List;

public class LottoResult {
    private final int lottoCount;
    private final boolean isBonus;
    private int returnCash;

    LottoResult(int lottoCount, boolean isBonus) {
        this.lottoCount = lottoCount;
        this.isBonus = isBonus;
        this.returnCash = Calculator.calculateReturn(lottoCount, isBonus);
    }

    public int getLottoCount() {
        return this.lottoCount;
    }

    public boolean getIsBonus() {
        return this.isBonus;
    }

    public int getReturnCash() {
        return this.returnCash;
    }
}
