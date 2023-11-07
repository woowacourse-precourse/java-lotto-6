package lotto.v2.model;

import lotto.v2.util.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultV2 {
    private Map<LottoRank, Integer> matchCounts = new HashMap<>();

    public LottoResultV2() {
        for (LottoRank rank : LottoRank.values()) {
            matchCounts.put(rank, 0);
        }
    }

    public Map<LottoRank, Integer> getWinningResult() {
        return matchCounts;
    }

    public void updateMatchCount(LottoV2 purchasedLotto, LottoV2 winningLotto, int bonusNumber) {
        int matchCount = purchasedLotto.matchCount(winningLotto);
        boolean bonusMatch = purchasedLotto.containsNumber(bonusNumber);

        try {
            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
            incrementMatchCount(rank);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void incrementMatchCount(LottoRank rank) {
        matchCounts.put(rank, matchCounts.getOrDefault(rank, 0) + 1);
    }

    public void calculateResults(List<LottoV2> purchasedLottos, LottoV2 winningLotto, int bonusNumber) {
        for (LottoV2 purchasedLotto : purchasedLottos) {
            updateMatchCount(purchasedLotto, winningLotto, bonusNumber);
        }
    }

    public void printStatistics() {
        for (Map.Entry<LottoRank, Integer> entry : matchCounts.entrySet()) {
            printStatisticForRank(entry);
        }
    }

    private void printStatisticForRank(Map.Entry<LottoRank, Integer> entry) {
        if (entry.getValue() > 0) {
            String matchString = getMatchString(entry.getKey());
            String prizeMoney = formatPrizeMoney(entry.getKey().getPrizeMoney());
            System.out.printf("%d개 일치%s (%s원) - %d개\n",
                    entry.getKey().getMatchCount(),
                    matchString,
                    prizeMoney,
                    entry.getValue());
        }
    }
    
    private String getMatchString(LottoRank rank) {
        return rank.isBonusMatch() ? ", 보너스 볼 일치" : "";
    }

    private String formatPrizeMoney(long prizeMoney) {
        return String.format("%,d", prizeMoney);
    }

    private long calculateTotalPrize() {
        long totalPrize = 0L;
        for (Map.Entry<LottoRank, Integer> entry : matchCounts.entrySet()) {
            totalPrize += entry.getValue() * entry.getKey().getPrizeMoney();
        }
        return totalPrize;
    }

    private double calculateYieldPercentage(long totalPrize, long totalSpent) {
        if (totalSpent > 0) {
            return (double) totalPrize / totalSpent * 100;
        }
        return 0;
    }

}
