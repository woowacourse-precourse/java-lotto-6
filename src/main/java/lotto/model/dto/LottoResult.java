package lotto.model.dto;

import lotto.model.MarginRate;
import lotto.model.WinningResult;

public class LottoResult {
    private final WinningResult winngResult;
    private final MarginRate marginRate;

    public LottoResult(WinningResult winngResult, MarginRate marginRate) {
        this.winngResult = winngResult;
        this.marginRate = marginRate;
    }

    public WinningResult getWinngResult() {
        return winngResult;
    }

    public MarginRate getMarginRate() {
        return marginRate;
    }
}
