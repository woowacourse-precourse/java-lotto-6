package lotto.exception;

public class NotEnoughMoneyException extends IllegalArgumentException {
    private static final String MESSAGE = "1,000원 이상의 금액을 입력해 주세요.";

    public NotEnoughMoneyException() {
        super(MESSAGE);
    }
}
