package lotto.exception;

public class ArgumentRangeOutOfBoundsException extends LottoIllegalArgumentException {
    public ArgumentRangeOutOfBoundsException() {
        super("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
