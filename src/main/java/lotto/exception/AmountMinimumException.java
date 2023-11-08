package lotto.exception;

public class AmountMinimumException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 로또 최소 구입 가능 금액은 1000원입니다.";
    public AmountMinimumException() {
        super(MESSAGE);
    }
}
