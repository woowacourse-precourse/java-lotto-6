package lotto.dto;

import java.math.BigDecimal;

public class LottoPurchaseInfo {
    private final BigDecimal purchaseAmount;
    private final BigDecimal lottoPrice;
    private final BigDecimal numberOfLottoPurchased;

    public LottoPurchaseInfo(BigDecimal purchaseAmount, BigDecimal lottoPrice) {
        this.purchaseAmount = purchaseAmount;
        this.lottoPrice = lottoPrice;
        numberOfLottoPurchased = purchaseAmount.divide(lottoPrice, BigDecimal.ROUND_DOWN);
    }

    private static void validateMultiplesOf(BigDecimal num, BigDecimal factor) {
        if (num.remainder(factor).compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalArgumentException(AMOUNT_IS_NOT_IN_THOUSAND_WON_UNITS.getMessage());
        }
    }

    public BigDecimal getLottoPrice() {
        return lottoPrice;
    }

    public BigDecimal getNumberOfLottoPurchased() {
        return numberOfLottoPurchased;
    }
}
