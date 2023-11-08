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
}