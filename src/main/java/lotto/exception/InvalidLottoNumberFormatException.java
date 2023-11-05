package lotto.exception;

public class InvalidLottoNumberFormatException extends InvalidLottoException {

    private static final String messageFormat = "입력된 ','구분자의 개수가 올바르지 않습니다. 입력된 개수 : %d";

    public InvalidLottoNumberFormatException(int splitterCount) {
        super(String.format(messageFormat, splitterCount));
    }
}
