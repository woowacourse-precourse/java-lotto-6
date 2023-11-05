package lotto;

public class LottoInputValidator {
    public static void purchasePriceIsValid(int purchasePrice) {
        if (purchasePrice % LottoConstants.LOTTO_PRICE.getConstant() != 0) {
            throw new IllegalArgumentException(
                    LottoErrorMessageConstants.PURCHASE_PRICE_NOT_INDIVISIBLE_PRICE_ERROR_MESSAGE.getMessage()
            );
        }
    }
}
