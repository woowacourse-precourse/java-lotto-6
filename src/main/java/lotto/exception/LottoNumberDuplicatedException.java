package lotto.exception;

public class LottoNumberDuplicatedException extends InvalidLottoException {

    private static final String message = "중복된 로또 번호가 존재합니다.";

    public LottoNumberDuplicatedException() {
        super(message);
    }
}
