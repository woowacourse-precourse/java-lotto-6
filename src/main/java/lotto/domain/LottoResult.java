package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> result;

    public LottoResult() {
        result = new EnumMap<>(LottoRank.class);
    }

    public void calculateResults(List<Integer> countResults, List<Boolean> bonusResults) {
        for (int i = 0; i < countResults.size(); i++) {
            LottoRank lottoRank = LottoRank.of(countResults.get(i), bonusResults.get(i));
            updateLottoResult(lottoRank);
        }
    }

    private void updateLottoResult(LottoRank lottoRank) {
        result.merge(lottoRank, 1, Integer::sum);
    }

    public int getCountByRank(LottoRank rank) {
        return result.getOrDefault(rank, 0);
    }

    public double calculateRate(Integer purchaseAmount) {
        Integer totalWinning = calculateTotalWinning();
        double profit = (double) (purchaseAmount - totalWinning) / purchaseAmount * 100;
        return 100 - Math.round(profit * 100.0) / 100.0;
    }

    private Integer calculateTotalWinning() {
        int totalWinning = 0;
        for (Map.Entry<LottoRank, Integer> entry : result.entrySet()) {
            int rankCount = entry.getValue();
            String winningAmount = entry.getKey().getWinningAmount();
            int amount = Integer.parseInt(winningAmount.replace(",", ""));
            totalWinning += rankCount * amount;
        }
        return totalWinning;
    }
}
