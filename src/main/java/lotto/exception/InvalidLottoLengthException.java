package lotto.exception;

public class InvalidLottoLengthException extends LottoIllegalArgumentException {
    public InvalidLottoLengthException() {
        super("로또에 필요한 수의 개수가 일치하지 않습니다.");
    }
}
