package lotto.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;

public class FinalGrade {
    private static final long PURCHASE_AMOUNT = 1000L;
    private final List<Rank> playerLottoResults;

    public FinalGrade(List<Rank> playerLottoResults) {
        this.playerLottoResults = playerLottoResults;
    }

    public BigDecimal getPlayerTotalPrize() {
        return playerLottoResults.stream()
                .map(Rank::getPrize)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getPlayerTotalPurchaseAmount() {
        return new BigDecimal(playerLottoResults.size() * PURCHASE_AMOUNT);
    }

    public EnumMap<Rank, Integer> getEachRankCounts() {
        EnumMap<Rank, Integer> eachRankCounts = initializeEachRankCounts();
        updateEachRankCounts(eachRankCounts);
        return eachRankCounts;
    }

    private EnumMap<Rank, Integer> initializeEachRankCounts() {
        EnumMap<Rank, Integer> eachRankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            eachRankCounts.put(rank, 0);
        }
        return eachRankCounts;
    }

    private void updateEachRankCounts(EnumMap<Rank, Integer> eachRankCounts) {
        for (Rank playerLottoResult : playerLottoResults) {
            eachRankCounts.put(playerLottoResult, eachRankCounts.getOrDefault(playerLottoResult, 0) + 1);
        }
    }
}
