package lotto.exception;

public class DuplicateLottoNumberException extends LottoException {
    private static final String ERROR_MESSAGE = "로또 번호 내부에서 번호가 중복됩니다.";

    public DuplicateLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}
