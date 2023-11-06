package lotto.domain;

import java.util.Map;

public class LottoResultsDTO {
    private final Map<LottoResults, Integer> result;
    private final long winningAmount;
    private final int lottoCount;

    public LottoResultsDTO(Map<LottoResults, Integer> result, long winningAmount, int lottoCount) {
        this.result = result;
        this.winningAmount = winningAmount;
        this.lottoCount = lottoCount;
    }

    public Map<LottoResults, Integer> getResult() {
        return result;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
