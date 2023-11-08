package lotto.validator;

public class BuyerValidator {
    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "구입 금액은 1,000원 단위입니다.");
        }
    }
}
