package lotto.v2.model;

import lotto.v2.util.LottoRankV2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultV2 {
    private Map<LottoRankV2, Integer> matchCounts = new HashMap<>();

    public LottoResultV2() {
        for (LottoRankV2 rank : LottoRankV2.values()) {
            matchCounts.put(rank, 0);
        }
    }

    public Map<LottoRankV2, Integer> getWinningResult() {
        return matchCounts;
    }

    public void updateMatchCount(LottoV2 purchasedLotto, LottoV2 winningLotto, int bonusNumber) {
        int matchCount = purchasedLotto.matchCount(winningLotto);
        boolean bonusMatch = purchasedLotto.containsNumber(bonusNumber);

        try {
            LottoRankV2 rank = LottoRankV2.valueOf(matchCount, bonusMatch);
            incrementMatchCount(rank);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 입력입니다. 다시 시도해주세요.");
        }
    }

    private void incrementMatchCount(LottoRankV2 rank) {
        matchCounts.put(rank, matchCounts.getOrDefault(rank, 0) + 1);
    }

    public void calculateResults(List<LottoV2> purchasedLottos, LottoV2 winningLotto, int bonusNumber) {
        for (LottoV2 purchasedLotto : purchasedLottos) {
            updateMatchCount(purchasedLotto, winningLotto, bonusNumber);
        }
    }

    public void printStatistics() {
        for (Map.Entry<LottoRankV2, Integer> entry : matchCounts.entrySet()) {
            printStatisticForRank(entry);
        }
    }

    private void printStatisticForRank(Map.Entry<LottoRankV2, Integer> entry) {
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

    private String getMatchString(LottoRankV2 rank) {
        if (rank.isBonusMatch()) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    private String formatPrizeMoney(long prizeMoney) {
        return String.format("%,d", prizeMoney);
    }

    private long calculateTotalPrize() {
        long totalPrize = 0L;
        for (Map.Entry<LottoRankV2, Integer> entry : matchCounts.entrySet()) {
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
