package lotto.exception;

public class PurchaseExceptionMessage extends IllegalArgumentException{

    public PurchaseExceptionMessage(String message){
        super(message);
    }

    public static void validateIsNumeric(String inputAmount) {
        if (!inputAmount.matches("\\d+")) {
            throw new PurchaseExceptionMessage("[ERROR] 구입금액이 유효하지 않습니다.");
        }
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new PurchaseExceptionMessage("[ERROR] 구입금액은 1,000단위이어야 합니다.");
        }
    }
}