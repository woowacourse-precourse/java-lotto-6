package lotto.exception.lotto.win;

public class LottoInputFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호의 입력 형식이 맞지 않습니다.";

    public LottoInputFormatException() {
        super(ERROR_MESSAGE);
    }
}
