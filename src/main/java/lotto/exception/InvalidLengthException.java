package lotto.exception;

public class InvalidLengthException extends LottoIllegalArgumentException {
    public InvalidLengthException() {
        super("로또에 필요한 수의 개수가 일치하지 않습니다.");
    }
}
