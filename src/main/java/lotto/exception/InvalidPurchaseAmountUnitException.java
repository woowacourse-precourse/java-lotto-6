package lotto.exception;

public class InvalidPurchaseAmountUnitException extends IllegalArgumentException {
    public InvalidPurchaseAmountUnitException() {
        super("[ERROR] 구입 금액은 천원 단위로 입력할 수 있습니다.\n");
    }
}
