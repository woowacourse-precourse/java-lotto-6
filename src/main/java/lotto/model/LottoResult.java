package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Prize, Integer> prizeCounts;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private List<List<Integer>> purchasedLottos;

    public LottoResult(List<Integer> winningNumbers, int bonusNumber, List<List<Integer>> purchasedLottos, Map<Prize, Integer> prizeCounts) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.purchasedLottos = purchasedLottos;
        this.prizeCounts  = prizeCounts ;
    }

    public Map<Prize, Integer> getPrizeStatistics() {
        Map<Prize, Integer> prizeStatistics = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            prizeStatistics.put(prize, countPrize(prize));
        }
        return prizeStatistics;
    }

    private int countPrize(Prize prize) {
        return (int) purchasedLottos.stream()
                .filter(lottoNumbers -> prize.match(winningNumbers, bonusNumber, lottoNumbers))
                .count();
    }

    public double calculateProfitRate(int purchaseAmount) {
        double totalPrize = calculateTotalPrize();
        return ((double) totalPrize / purchaseAmount) * 100;
    }

    private double calculateTotalPrize() {
        double totalPrize = 0;
        for (Prize prize : Prize.values()) {
            totalPrize += prize.getAmount() * countPrize(prize);
        }
        return totalPrize;
    }
}
