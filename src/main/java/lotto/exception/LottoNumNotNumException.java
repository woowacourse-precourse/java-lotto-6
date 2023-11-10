package lotto.exception;

public class LottoNumNotNumException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 금액은 숫자만 등록 가능합니다.";

    public LottoNumNotNumException(){
        super(ERROR_MESSAGE);
    }
}
