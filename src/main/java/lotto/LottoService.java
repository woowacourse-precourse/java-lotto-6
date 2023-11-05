package lotto;

import java.util.EnumMap;
import java.util.List;

public class LottoService {

    public Result getWinningResult(List<Lotto> lottos, WinningNumber winningNumber) {
        EnumMap<Rank, Integer> rankToCount = getRankToCount(lottos, winningNumber);
        long totalPrize = Rank.getTotalPrize(rankToCount);
        double rateOfReturn = getRateOfReturn(totalPrize, lottos.size());
        return new Result(rankToCount, rateOfReturn);
    }

    private EnumMap<Rank, Integer> getRankToCount(List<Lotto> lottos, WinningNumber winningNumber) {
        EnumMap<Rank, Integer> rankToInteger = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            Rank rank = Rank.of(lotto, winningNumber);
            rankToInteger.put(rank, rankToInteger.getOrDefault(rank, 0) + 1);
        }
        return rankToInteger;
    }

    private double getRateOfReturn(long totalPrize, int quantity) {
        return ((double) totalPrize / ((long) PurchaseQuantity.unit * quantity)) * 100;
    }
}
