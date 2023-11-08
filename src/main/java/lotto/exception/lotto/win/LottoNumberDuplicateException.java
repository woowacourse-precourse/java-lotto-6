package lotto.exception.lotto.win;

public class LottoNumberDuplicateException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 입력된 번호 중 중복된 번호가 있습니다.";

    public LottoNumberDuplicateException() {
        super(ERROR_MESSAGE);
    }
}
