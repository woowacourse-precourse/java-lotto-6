package lotto.dto;

import java.math.BigDecimal;
import lotto.utils.Util;

public class LottoPurchaseInfo {
    private final BigDecimal purchaseAmount;
    private final BigDecimal lottoPrice;
    private final BigDecimal numberOfLottoPurchased;

    public LottoPurchaseInfo(BigDecimal purchaseAmount, BigDecimal lottoPrice) {
        this.purchaseAmount = purchaseAmount;
        this.lottoPrice = lottoPrice;
        Util.validateMultiplesOf(purchaseAmount, lottoPrice);
        numberOfLottoPurchased = Util.getHowManyTimes(purchaseAmount, lottoPrice);
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
