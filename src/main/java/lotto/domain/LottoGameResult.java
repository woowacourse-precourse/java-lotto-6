package lotto.domain;

import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.prize.LottoPrizeType;
import lotto.domain.prize.TotalPrizeAmount;

public class LottoGameResult {

    private final Map<LottoPrizeType, Integer> winningCountByPrizeType;

    public LottoGameResult(Map<LottoPrizeType, Integer> winningCountByPrizeType) {
        this.winningCountByPrizeType = winningCountByPrizeType;
    }

    public TotalPrizeAmount calculateTotalPrizeAmount() {
        BigDecimal totalAmount = winningCountByPrizeType.keySet()
                .stream()
                .map(prizeType -> prizeType.calculateAmount(this.winningCountByPrizeType.getOrDefault(prizeType, 0)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new TotalPrizeAmount(totalAmount);
    }

}
