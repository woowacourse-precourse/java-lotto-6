package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {
    private static Map<Prize, Integer> prizeStatistics;
    private WinningNumbers winningNumbers;

    public GameManager() {
        prizeStatistics = new HashMap<>();
        for (Prize prize : Prize.values()) {
            prizeStatistics.put(prize, 0);
        }
    }

    public int calculatePurchaseQuantity(int purchasePrice) {
        int removeCount = 3;
        int removed = 0;
        int purchaseQuantity = purchasePrice;
        while (removed < removeCount) {
            purchaseQuantity /= 10;
            removed++;
        }

        return purchaseQuantity;
    }

    public void saveWinningNumbers(List<Integer> numbers, int bonusNumber) {
        winningNumbers = new WinningNumbers(numbers, bonusNumber);
    }

    public void updatePrizeStatistic(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            int userMatchedCount = winningNumbers.compareWith(lotto);
            if (userMatchedCount == Prize.SECOND.matchedCount && winningNumbers.isBonusNumberMatched(lotto)) {
                savePrizeCount(Prize.SECOND);
                break;
            }
            savePrizeCount(Prize.getPrize(userMatchedCount));
        }
    }

    public void savePrizeCount(Prize prize) {
        int currentMatchedCount = prizeStatistics.get(prize);
        prizeStatistics.put(prize, currentMatchedCount + 1);
    }

    public double calculateEarningRate(int purchasePrice, int totalPrizeMoney) {
        double earningRate = (double) ((totalPrizeMoney - purchasePrice) / purchasePrice) * 100;
        return Math.round(earningRate * 10) * 10;
    }

    public Map<Prize, Integer> getPrizeStatistics() {
        return prizeStatistics;
    }
}
