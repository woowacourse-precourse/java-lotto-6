package lotto.model;

import java.util.HashMap;
import java.util.Map;
import lotto.utils.WinningRank;

public class WinningStatistics {
    private static final int PROFIT_RATE_PERCENTAGE = 100;
    private Map<WinningRank, Integer> winningRecords;
    private int totalWinningAmount;
    private double profitRate;
    private int purchaseAmount;

    public WinningStatistics(int purchaseAmount) {
        totalWinningAmount = 0;

        winningRecords = new HashMap<>();
        for (WinningRank rank : WinningRank.values()) {
            winningRecords.put(rank, 0);
        }
        this.purchaseAmount = purchaseAmount;
    }

    public void updateStatistics(WinningRank rank) {
        updateWinningCount(rank);
        calculateTotalAmount(rank.getWinningAmount());
    }


    private void updateWinningCount(WinningRank winningRank) {
        int updatedWinningCount = winningRecords.get(winningRank) + 1;
        winningRecords.put(winningRank, updatedWinningCount);
    }

    public void calculateProfitRate() {
        profitRate = ((double) totalWinningAmount) / purchaseAmount * PROFIT_RATE_PERCENTAGE;
    }

    private void calculateTotalAmount(int additionalAmount) {
        this.totalWinningAmount += additionalAmount;
    }

    @Override
    public String toString() {
        return winningRecordsToString() + profitRateToString();
    }

    private String winningRecordsToString() {
        StringBuilder formattedWinningRecords = new StringBuilder();
        for (WinningRank rank : WinningRank.values()) {
            if (rank == WinningRank.OUT_OF_RANK) {
                continue;
            }
            formattedWinningRecords.append(rank);
            formattedWinningRecords.append(winningCountToString(rank));
            formattedWinningRecords.append("\n");
        }
        return formattedWinningRecords.toString();
    }

    private String winningCountToString(WinningRank rank) {
        return " - " + winningRecords.get(rank) + "개";
    }

    private String profitRateToString() {
        String formatPattern = "%.1f%%";
        return "총 수익률은 " + String.format(formatPattern, profitRate) + "입니다.";
    }

    // for test
//
//    public Map<WinningRank, Integer> getWinningRecords() {
//        return winningRecords;
//    }
//
//    public int getTotalWinningAmount() {
//        return totalWinningAmount;
//    }
//
//    public double getProfitRate() {
//        return profitRate;
//    }
}
