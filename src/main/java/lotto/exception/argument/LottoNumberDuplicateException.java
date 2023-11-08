package lotto.exception.argument;

public class LottoNumberDuplicateException extends BaseIllegalArgumentException {
    private static final String MESSAGE = "로또 번호는 중복될 수 없습니다.";

    public LottoNumberDuplicateException() {
        super(MESSAGE);
    }
}
