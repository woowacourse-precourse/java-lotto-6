package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Profit {
    Map<WinningDetails, Integer> winningResult; // 당첨내역
    int totalProfit;
    String profitRatio;

    public Profit() {
        winningResult = new HashMap<>();
        for (WinningDetails winningDetails : WinningDetails.values()) {
            winningResult.put(winningDetails, 0);
        }
        totalProfit = 0;
    }

    public void addResult(WinningDetails winningDetails) {
        if (winningDetails == null) {
            return;
        }
        winningResult.compute(winningDetails, (key, value) -> value + 1);
    }

    public void setTotalProfit() {
        int totalProfit = 0;
        for (WinningDetails winningDetails : WinningDetails.values()) {
            totalProfit += (winningResult.get(winningDetails)) * winningDetails.getPrizeMoney();
        }
        this.totalProfit = totalProfit;
    }

    public Map<WinningDetails, Integer> getWinningResult() {
        return this.winningResult;
    }

    public void setProfitRatio(int purchaseAmount) {
        this.profitRatio = matchDecimalPlace(((double) totalProfit) / purchaseAmount * 100);
    }

    public String matchDecimalPlace(Double ratio) {
        return String.format("%.1f", ratio);
    }

    public String getProfitRatio() {
        return this.profitRatio;
    }
}
