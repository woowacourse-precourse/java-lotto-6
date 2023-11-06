package lotto.domain.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import lotto.domain.dto.Result;
import lotto.utils.RandomNumberGenerator;

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
        return ((double) totalPrize / ((long) PurchaseAmount.unit * quantity)) * 100;
    }

    public List<Lotto> purchase(PurchaseAmount purchaseAmount) {

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount.getQuantity(); i++) {
            lottos.add(new Lotto(RandomNumberGenerator.generateUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }
}
