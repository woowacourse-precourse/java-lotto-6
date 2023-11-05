package lotto.domain;

public class LottoPurchaseCalculator {

    public int calculateLottoCount(int lottoPrice, Money money) {

        int amount = money.getAmount();
        int zero = LottoConfig.ZERO.getValue();

        if (lottoPrice <= zero) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_LOTTO_PRICE.getMessage());
        }
        if (amount % lottoPrice != zero) {
            throw new IllegalArgumentException(
                    LottoErrorMessages.NOT_DIVISIBLE_AMOUNT.getMessage());
        }
        return amount / lottoPrice;
    }

}
