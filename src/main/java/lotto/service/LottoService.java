package lotto.service;

import lotto.domain.WinningPrize;
import lotto.model.WinningInfo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoService {
    private WinningInfo winningInfo;

    public LottoService(WinningInfo winningInfo) {
        this.winningInfo = winningInfo;
    }
    public LottoService(){

    }

    public void WinningResults(Map<Long, Long> winningResults) {
        LinkedHashMap<Long, Long> winnings = winningInfo.getWinnings();

        for (Map.Entry<Long, Long> resultEntry : winningResults.entrySet()) {
            long prizeMatchingCount = resultEntry.getKey();
            Long winningCount = resultEntry.getValue();

            // Check if the key exists in the WinningInfo model
            if (winnings.containsKey(prizeMatchingCount)) {
                // Increment the count in the WinningInfo model
                winnings.put(prizeMatchingCount, winnings.get(prizeMatchingCount) + winningCount);
            }
        }

        // Update the WinningInfo model with the modified winnings
        winningInfo.setWinnings(winnings);
    }

    public double calculateProfitRate(int buyCount, Map<Long, Long> winningResults) {
        long totalPrize = 0L;

        // Calculate total prize by matching the keys from winningResults with WinningPrize keys
        for (Map.Entry<Long, Long> resultEntry : winningResults.entrySet()) {
            long prizeMatchingCount = resultEntry.getKey();
            Long winningCount = resultEntry.getValue();

            String prizeAmount = WinningPrize.getPrizeMap().get((int) prizeMatchingCount);
            if (prizeAmount != null) {
                long prizeValue = Long.parseLong(prizeAmount.replace(",", ""));
                totalPrize += prizeValue * winningCount;
            }
        }

        // Calculate profit
        long totalCost = buyCount * 1000;
        double profitRate = ((totalPrize - totalCost) / (double) totalCost) * 100.0;


        // Set the calculated profit rate in the WinningInfo object
        return profitRate;
    }

}