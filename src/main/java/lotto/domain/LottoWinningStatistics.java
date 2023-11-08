package lotto.domain;

import lotto.dto.LottoStatisticsResult;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoWinningStatistics {

    public LottoStatisticsResult calculateStatistics(Amount purchaseAmount, List<LottoWinningTier> tiers) {
        Map<LottoWinningTier, Integer> winningTierCountStatistics = createWinningTierCountStatistics();
        calculateWinningTierCount(winningTierCountStatistics, tiers);

        Amount totalWinningAmount = calculateTotalWinningAmount(winningTierCountStatistics);
        double percentOfTotalWinningAmount = totalWinningAmount.calculatePercentByUnitAmount(purchaseAmount);

        return new LottoStatisticsResult(winningTierCountStatistics, percentOfTotalWinningAmount);
    }

    private Map<LottoWinningTier, Integer> createWinningTierCountStatistics() {
        Map<LottoWinningTier, Integer> winningTierCountStatistics = new EnumMap<>(LottoWinningTier.class);
        Arrays.stream(LottoWinningTier.values())
                .forEach(tier -> winningTierCountStatistics.put(tier, 0));

        return winningTierCountStatistics;
    }

    private void calculateWinningTierCount(Map<LottoWinningTier, Integer> winningTierCountStatistics,
                                                  List<LottoWinningTier> tiers) {
        tiers.forEach(tier -> increaseWinningTierCount(winningTierCountStatistics, tier));
    }

    private void increaseWinningTierCount(Map<LottoWinningTier, Integer> winningTierCountStatistics,
                                                 LottoWinningTier winningTier) {
        winningTierCountStatistics.put(winningTier, addOneToBeforeValue(winningTierCountStatistics, winningTier));
    }

    private int addOneToBeforeValue(Map<LottoWinningTier, Integer> winningTierCountStatistics,
                                           LottoWinningTier winningTier) {
        return winningTierCountStatistics.get(winningTier) + 1;
    }

    private Amount calculateTotalWinningAmount(Map<LottoWinningTier, Integer> winningTierCountStatistics) {
        return winningTierCountStatistics.entrySet()
                .stream()
                .map(this::calculateTotalTierAmount)
                .reduce(Amount::plusAmount)
                .orElseGet(Amount::createZeroAmount);
    }

    private Amount calculateTotalTierAmount(Entry<LottoWinningTier, Integer> tierCountEntry) {
        LottoWinningTier tier = tierCountEntry.getKey();
        Integer count = tierCountEntry.getValue();
        return tier.getPrizeAmount()
                .calculateMultiplyAmount(count);
    }
}
