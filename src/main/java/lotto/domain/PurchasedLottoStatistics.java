package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public final class PurchasedLottoStatistics {

    private final Map<LottoWinning, Long> value;

    public PurchasedLottoStatistics(Map<LottoWinning, Long> value) {
        this.value = value;
    }

    public Long countWinningLotto(LottoWinning lottoWinning) {
        return value.get(lottoWinning);
    }

    public BigDecimal calculateRevenueRatio() {
        return getTotalPrice().divide(getPurchaseAmount(), 2, RoundingMode.HALF_DOWN);
    }

    private BigDecimal getPurchaseAmount() {
        long purchaseAmount = this.value.values().stream()
                .reduce(0L, Long::sum);
        return BigDecimal.valueOf(purchaseAmount);
    }

    private BigDecimal getTotalPrice() {
        long totalPrice = this.value.keySet().stream()
                .mapToLong(lottoWinning -> lottoWinning.prize)
                .reduce(0L, Long::sum);
        return BigDecimal.valueOf(totalPrice);
    }
}
