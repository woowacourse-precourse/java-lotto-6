package lotto.model;

import lotto.model.Lotto;

import java.util.List;

public class LottoInfo {
    private final Lotto lotto;
    private Integer matchCount;
    private boolean matchBonus;
    public LottoInfo(Lotto lotto) {
        this.lotto = lotto;
        this.matchCount = 0;
        this.matchBonus = false;
    }
    public Lotto getLotto() {
        return this.lotto;
    }
    public Integer getMatchCount() {
        return this.matchCount;
    }
}
