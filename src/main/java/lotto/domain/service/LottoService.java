package lotto.domain.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public Result getWinningResult(List<Lotto> lottos, WinningNumber winningNumber, PurchaseAmount purchaseAmount) {
        EnumMap<Rank, Integer> rankToCount = getRankToCount(lottos, winningNumber);
        long totalPrize = Rank.getTotalPrize(rankToCount);
        BigDecimal rateOfReturn = getRateOfReturn(totalPrize, purchaseAmount);
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

    private BigDecimal getRateOfReturn(long totalPrize, PurchaseAmount purchaseAmount) {
        return new BigDecimal(totalPrize)
                .multiply(new BigDecimal("100"))
                .divide(new BigDecimal(purchaseAmount.getAmount()), 1, RoundingMode.HALF_UP);
    }

    public List<Lotto> purchase(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        long quantity = purchaseAmount.getQuantity();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(RandomNumberGenerator.generateUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }
}
