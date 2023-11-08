package lotto;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GameManager {
    private static Map<Prize, Integer> prizeStatistics;
    private WinningNumbers winningNumbers;
    private int totalPrizeMoney;

    public GameManager() {
        prizeStatistics = new TreeMap<>();
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

    public String calculateEarningRate(int purchasePrice) {
        int totalPrizeMoney = calculateTotalPrizeMoney();
        double earningRate = (double)totalPrizeMoney / (double) purchasePrice * 100.0;
        return String.format("%.1f",earningRate);
    }

    public int calculateTotalPrizeMoney() {
        for (Map.Entry<Prize, Integer> entry : prizeStatistics.entrySet()) {
            Prize prize = entry.getKey();
            int prizeCount = entry.getValue();
            if (prizeCount != 0) {
                totalPrizeMoney += prize.prizeMoney * prizeCount;
            }
        }

        return totalPrizeMoney;
    }

    public Map<Prize, Integer> getPrizeStatistics() {
        return prizeStatistics;
    }
}
