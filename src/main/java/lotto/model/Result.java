package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
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
        int sum = 0;
        for (PrizeRank prizeRank : prizeCounts.keySet()) {
            Integer count = prizeCounts.get(prizeRank);
            int price = prizeRank.getPrice();
            sum += (count * price);
        }

        int purchaseAmount = purchase.getPurchaseCount() * 1000;
        double profitRate = ((double) (sum - purchaseAmount) / purchaseAmount) * 100;

        // 소수점 둘째 자리에서 반올림
        profitRate = Math.round(profitRate * 10) / 10.0;

        return 100 + profitRate;
    }
}
