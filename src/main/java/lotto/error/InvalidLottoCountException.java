package lotto.error;

public class InvalidLottoCountException extends IllegalArgumentException {
    public InvalidLottoCountException(String message) {
        super(message);
    }
}