package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    private static final double PROFIT_RATE_MULTIPLIER = 1000.0;
    private static final double PROFIT_RATE_PERCENTAGE = 100.0;
    private static final double PROFIT_RATE_BASE = 10.0;
    private static final int DEFAULT_COUNT = 0;

    private final Map<PrizeRank, Integer> prizeCounts;
    private final Jackpot jackpot;
    private final List<Lotto> lottos;
    private final Purchase purchase;

    public Result(Jackpot jackpot, List<Lotto> lottos, Purchase purchase) {
        this.jackpot = jackpot;
        this.lottos = lottos;
        this.purchase = purchase;
        this.prizeCounts = new EnumMap<>(PrizeRank.class);
        for (PrizeRank rank : PrizeRank.values()) {
            prizeCounts.put(rank, DEFAULT_COUNT);
        }
    }

    // 어느 등수에 몇번 당첨되었는지 계산하는 기능
    public void calculateWinningRanks() {
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), jackpot.getWinningNumbers());
            boolean hasBonus = lotto.getNumbers().contains(jackpot.getBonusNumber());
            PrizeRank rank = PrizeRank.findPrizeRankByMatches(matchCount, hasBonus);

            if (rank != null) {
                prizeCounts.put(rank, prizeCounts.get(rank) + 1);
            }
        }
    }

    private static int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer winningNumber : winningNumbers) {
            if (lottoNumbers.contains(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public int getCountByRank(PrizeRank rank) {
        return prizeCounts.getOrDefault(rank, 0);
    }

    public Double calculateProfitRate() {
        int sum = sumPrizeAmounts();
        int purchaseAmount = getPurchaseAmount();
        double profitRate = ((double) (sum - purchaseAmount) / purchaseAmount) * PROFIT_RATE_MULTIPLIER;
        profitRate = PROFIT_RATE_PERCENTAGE + (Math.round(profitRate) / PROFIT_RATE_BASE);

        return profitRate;
    }

    private int getPurchaseAmount() {
        return purchase.getPurchaseCount() * 1000;
    }

    private int sumPrizeAmounts() {
        int sum = 0;
        for (PrizeRank prizeRank : prizeCounts.keySet()) {
            Integer count = prizeCounts.get(prizeRank);
            int price = prizeRank.getPrice();
            sum += (count * price);
        }
        return sum;
    }
}
