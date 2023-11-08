package validator;

public class LottoPurchaseValidator {
    public static final String INVALID_MINIMUM_PURCHASE_AMOUNT = "[ERROR] 로또 최소 구입금액은 1000원 입니다.";
    public static final String INVALID_PURCHASE_AMOUNT_DIVIDE_UP_1000 = "[ERROR] 로또 구입금액은 1000원 단위여야 합니다.";
    public static final String INVALID_INTEGER_PURCHASE_AMOUNT = "[ERROR] 로또 구입 금액에는 숫자만 입력해주세요.";

    public int validPurchaseAmount(String purchaseAmount) {
        vaildIntegerPurchaseAmount(purchaseAmount);
        int purchaseAmountPrice = Integer.parseInt(purchaseAmount);
        validMinimumPurchaseAmount(purchaseAmountPrice);
        validPurchaseDivideUp1000(purchaseAmountPrice);
        return purchaseAmountPrice;
    }

    void validMinimumPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException(INVALID_MINIMUM_PURCHASE_AMOUNT);
        }
    }

    void validPurchaseDivideUp1000(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_DIVIDE_UP_1000);
        }
    }

    void vaildIntegerPurchaseAmount(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(INVALID_INTEGER_PURCHASE_AMOUNT);
        }
    }
}
