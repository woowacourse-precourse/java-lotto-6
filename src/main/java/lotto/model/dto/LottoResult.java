package lotto.model.dto;

import lotto.model.MarginRate;
import lotto.model.WinningResult;

public class LottoResult {
    private final WinningResult winningResult;
    private final MarginRate marginRate;

    public LottoResult(WinningResult winningResult, MarginRate marginRate) {
        this.winningResult = winningResult;
        this.marginRate = marginRate;
    }

    public WinningResult getWinningResult() {
        return this.winningResult;
    }

    public MarginRate getMarginRate() {
        return this.marginRate;
    }
}
