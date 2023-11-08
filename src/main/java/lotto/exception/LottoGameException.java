package lotto.exception;

public class LottoGameException extends Exception {
    public LottoGameException(ErrorMessage message) {
        super(message.getMessage());
    }
}
