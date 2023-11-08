package lotto.exception;

public class MissingPurchaseAmountException extends IllegalArgumentException {
    public MissingPurchaseAmountException() {
        super("[ERROR] 구입 금액은 공백일 수 없습니다.\n");
    }
}
