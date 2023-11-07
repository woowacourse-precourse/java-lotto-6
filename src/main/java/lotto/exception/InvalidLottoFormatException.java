package lotto.exception;

public class InvalidLottoFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "로또 번호 입력 형식이 잘 못 되었습니다.";

    public InvalidLottoFormatException() {
        super(ERROR_MESSAGE);
    }
}
