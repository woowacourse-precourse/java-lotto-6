package lotto;

import java.util.EnumMap;

public class LottoResult {
    static final int PRICE_OF_LOTTO = 1000;
    
    private final EnumMap<Rank, Integer> rankCounts;
    private double rateOfReturn;

    public LottoResult() {
        rankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public void addRankCount(Rank rank) {
        rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
    }

    public void calculateRateOfReturn(int purchaseAmount) {
        long totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += rank.getPrizeMoney() * rankCounts.getOrDefault(rank, 0);
        }
        rateOfReturn = (double) totalPrize / (purchaseAmount * PRICE_OF_LOTTO) * 100;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public EnumMap<Rank, Integer> getRankCounts() {
        return rankCounts;
    }
}
