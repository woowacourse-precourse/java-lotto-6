package lotto.domain;

import lotto.constants.WinningInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningChecker {
    private double totalWinningAmount;
    private Map<Integer, Integer> rankInfo;

    public WinningChecker() {
        this.totalWinningAmount = 0;
        this.rankInfo = new HashMap<>();
    }

    public static WinningChecker createWinningChecker() {
        return new WinningChecker();
    }

    public void checkWinning(Customer customer) {
        List<WinningInfo> winningInfos = customer.getWinningInfos();
        calculateTotalWinningAmount(winningInfos);
        countNumberOfRankByResults(winningInfos);
    }

    private void calculateTotalWinningAmount(List<WinningInfo> winningInfos) {
        for (WinningInfo winningInfo : winningInfos) {
            this.totalWinningAmount += winningInfo.getAmount();
        }
    }

    // Result에 저장된 등수를 바탕으로 등수 별 당첨 개수 저장
    private void countNumberOfRankByResults(List<WinningInfo> winningInfos) {
        for (WinningInfo winningInfo : winningInfos) {
            int rank = winningInfo.getRank();
            this.rankInfo.put(rank, this.rankInfo.getOrDefault(rank, 0) + 1);
        }
    }

    public Map<Integer, Integer> getRankInfo() {
        return this.rankInfo;
    }

    public double getTotalWinningAmount() {
        return this.totalWinningAmount;
    }
}
