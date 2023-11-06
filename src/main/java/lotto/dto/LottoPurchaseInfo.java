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

    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    public BigDecimal getLottoPrice() {
        return lottoPrice;
    }

    public BigDecimal getNumberOfLottoPurchased() {
        return numberOfLottoPurchased;
    }
}
