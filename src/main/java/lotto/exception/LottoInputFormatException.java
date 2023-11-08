package lotto.exception;

public class LottoInputFormatException extends Throwable {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호는 쉼표(,)로 구분되어야 합니다.";
    
    public LottoInputFormatException() {
        super(ERROR_MESSAGE);
    }
}
