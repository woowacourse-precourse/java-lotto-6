package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    private static final int DEFAULT_COUNT = 0;

    private final Map<PrizeRank, Integer> prizeCounts;
    private final Jackpot jackpot;
    private final List<Lotto> lottos;

    public Result(Jackpot jackpot, List<Lotto> lottos) {
        this.jackpot = jackpot;
        this.lottos = lottos;
        this.prizeCounts = new EnumMap<>(PrizeRank.class);
        for (PrizeRank rank : PrizeRank.values()) {
            prizeCounts.put(rank, DEFAULT_COUNT);
        }
    }

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
}
