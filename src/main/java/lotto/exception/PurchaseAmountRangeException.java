package lotto.exception;

public class PurchaseAmountRangeException extends RuntimeException {
    private static final String MESSAGE = "[ERROR] 로또 구입 금액은 1000원 이상 100000원 이하로 입력해주세요.";

    public PurchaseAmountRangeException() {
        super(MESSAGE);
    }
}
