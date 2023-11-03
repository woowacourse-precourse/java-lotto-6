package lotto.exception;

public class IllegalOverValueException extends LottoApplicationException {
    private static final String DEFAULT_MESSAGE = "보너스 번호는 1자리 입니다.";

    public IllegalOverValueException() {
        super(DEFAULT_MESSAGE);
    }
}
