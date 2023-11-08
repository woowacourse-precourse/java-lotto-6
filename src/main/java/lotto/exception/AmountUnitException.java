package lotto.exception;

public class AmountUnitException extends IllegalArgumentException{
    private static final String MESSAGE = "[ERROR] 로또 금액은 1000원 단위입니다.";
    public AmountUnitException() {
        super(MESSAGE);
    }
}
