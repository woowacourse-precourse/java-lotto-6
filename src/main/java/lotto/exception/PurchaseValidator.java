package lotto.exception;

public class PurchaseValidator extends IllegalArgumentException {

    public PurchaseValidator(String message) {
        super(message);
    }

    public static void checkIsNumeric(String inputAmount) {
        if (!inputAmount.matches("\\d+")) {
            throw new PurchaseValidator("[ERROR] 구입금액이 유효하지 않습니다.");
        }
    }

    public static void checkValidPurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new PurchaseValidator("[ERROR] 구입금액은 1,000단위이어야 합니다.");
        }
    }
}