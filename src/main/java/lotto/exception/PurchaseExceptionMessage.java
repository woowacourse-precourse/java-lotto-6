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
}