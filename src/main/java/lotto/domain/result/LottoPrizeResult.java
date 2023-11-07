package lotto.domain.result;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import lotto.domain.prize.LottoPrizeType;

public class LottoPrizeResult {

    private final Map<LottoPrizeType, Integer> winningCountByPrizeType;

    public LottoPrizeResult(Map<LottoPrizeType, Integer> winningCountByPrizeType) {
        this.winningCountByPrizeType = winningCountByPrizeType;
    }

    public TotalPrizeAmount calculateTotalPrizeAmount() {
        BigDecimal totalAmount = winningCountByPrizeType.keySet()
                .stream()
                .map(prizeType -> prizeType.calculateAmount(this.winningCountByPrizeType.getOrDefault(prizeType, 0)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new TotalPrizeAmount(totalAmount);
    }

    public Map<LottoPrizeType, Integer> getWinningCountByPrizeType() {
        return Collections.unmodifiableMap(this.winningCountByPrizeType);
    }

}
