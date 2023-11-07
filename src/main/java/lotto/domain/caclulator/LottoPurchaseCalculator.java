package lotto.domain.caclulator;

import lotto.domain.LottoConfig;
import lotto.domain.model.Money;

public class LottoPurchaseCalculator {

    public static int calculateLottoCount(int lottoPrice, Money money) {

        int amount = money.getAmount();

        validateLottoPrice(lottoPrice);
        validateAmountDivisibility(amount, lottoPrice);
        return amount / lottoPrice;
    }

    private static void validateLottoPrice(int lottoPrice) {
        if (lottoPrice <= LottoConfig.ZERO.getValue()) {
            throw new IllegalArgumentException(
                    LottoCalculatorErrorMessage.INVALID_LOTTO_PRICE.getMessage());
        }
    }

    private static void validateAmountDivisibility(int amount, int lottoPrice) {
        if (amount % lottoPrice != LottoConfig.ZERO.getValue()) {
            throw new IllegalArgumentException(
                    LottoCalculatorErrorMessage.NOT_DIVISIBLE_AMOUNT.getMessage());
        }
    }

}
