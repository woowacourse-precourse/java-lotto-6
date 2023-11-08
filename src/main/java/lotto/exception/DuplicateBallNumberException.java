package lotto.exception;

public class DuplicateBallNumberException extends LottoIllegalArgumentException {
    public DuplicateBallNumberException() {
        super("로또 번호는 중복되는 수가 없어야 합니다.");
    }
}
