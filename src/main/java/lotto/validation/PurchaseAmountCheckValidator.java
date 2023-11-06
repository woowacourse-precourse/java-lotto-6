package lotto.validation;

public class PurchaseAmountCheckValidator {
    private static final String ERROR = "[ERROR] ";

    public static int validatePurchaseAmount(String stringPurchaseAmount) {
        int purchaseAmount = 0;

        try {
            purchaseAmount = Integer.parseInt(stringPurchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR + "숫자를 입력해 주세요");
        }

        if (purchaseAmount % 1_000 != 0) {
            throw new IllegalArgumentException(ERROR + "구입금액은 1,000원 단위로 입력해주세요");
        }
        return purchaseAmount;
    }
}