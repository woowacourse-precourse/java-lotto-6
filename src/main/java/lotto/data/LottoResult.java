package lotto.data;

import java.util.List;

public class LottoResult {
    private final List<Integer> winningResult;
    private final int totalPrize;

    public LottoResult(List<Integer> winningResult, int totalPrize) {
        this.winningResult = winningResult;
        this.totalPrize = totalPrize;
    }

    public int getTotalPrize() {
        return totalPrize;
    }

    public List<Integer> getWinningResult() {
        return winningResult;
    }
}
