package lotto.exception;

public class InvalidPurchaseAmountFormatException extends IllegalArgumentException {
    public InvalidPurchaseAmountFormatException() {
        super("[ERROR] 구입 금액은 숫자만 입력할 수 있습니다.\n");
    }
}
