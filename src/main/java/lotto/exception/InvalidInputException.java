package lotto.exception;

public class InvalidInputException extends LottoIllegalArgumentException {
    public InvalidInputException() {
        super("올바르지 않은 입력입니다.");
    }
}
