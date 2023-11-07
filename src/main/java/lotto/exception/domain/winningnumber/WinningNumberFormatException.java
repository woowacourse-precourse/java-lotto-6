package lotto.exception.domain.winningnumber;

public class WinningNumberFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호에는 숫자, 공백, 콤마(,)만 입력할 수 있습니다.";

    public WinningNumberFormatException() {
        super(ERROR_MESSAGE);
    }
}
