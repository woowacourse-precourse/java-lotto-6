package lotto.exception;

public class LottoNumDuplicateException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또 번호내에 중복되는 숫자가 존재합니다.";

    public LottoNumDuplicateException(){
        super(ERROR_MESSAGE);
    }
}
