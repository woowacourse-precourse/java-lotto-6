package lotto;

import java.util.ArrayList;
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
        for (Rank rank : Rank.values()) {
            rankToInteger.put(rank, 0);
        }
        for (Lotto lotto : lottos) {
            Rank rank = Rank.of(lotto, winningNumber);
            rankToInteger.put(rank, rankToInteger.get(rank) + 1);
        }
        rankToInteger.remove(Rank.NONE);
        return rankToInteger;
    }

    private double getRateOfReturn(long totalPrize, int quantity) {
        return ((double) totalPrize / ((long) PurchaseQuantity.unit * quantity)) * 100;
    }

    public List<Lotto> purchase(int purchaseAmount) {
        PurchaseQuantity purchaseQuantity = new PurchaseQuantity(purchaseAmount);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity.getQuantity(); i++) {
            lottos.add(new Lotto(RandomNumberGenerator.generateUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }
}
