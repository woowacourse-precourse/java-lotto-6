package lotto;

import java.util.List;

public class LottoResult {
    private List<Integer> winningResult;
    private int totalPrize;

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
