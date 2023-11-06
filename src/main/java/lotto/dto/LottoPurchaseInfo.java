package lotto.dto;

import static lotto.message.ErrorMessage.AMOUNT_IS_NOT_IN_THOUSAND_WON_UNITS;

import java.math.BigDecimal;

public class LottoPurchaseInfo {
    public final BigDecimal purchaseAmount;
    public final BigDecimal lottoPrice;
    public final BigDecimal numberOfLottoPurchased;

    public LottoPurchaseInfo(BigDecimal purchaseAmount, BigDecimal lottoPrice) {
        validateMultiplesOf(purchaseAmount, lottoPrice);

        this.purchaseAmount = purchaseAmount;
        this.lottoPrice = lottoPrice;
        numberOfLottoPurchased = purchaseAmount.divide(lottoPrice, BigDecimal.ROUND_DOWN);
    }

    private static void validateMultiplesOf(BigDecimal num, BigDecimal factor) {
        if (num.remainder(factor).compareTo(BigDecimal.ZERO) != 0) {
            throw new IllegalArgumentException(AMOUNT_IS_NOT_IN_THOUSAND_WON_UNITS.getMessage());
        }
    }
}
