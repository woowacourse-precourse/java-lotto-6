package lotto.exception;

public class InvalidLottoNumberFormatException extends InvalidLottoException {

    private static final String messageFormat = "(%s)는 정수로 변환될 수 없는 값입니다.";

    public InvalidLottoNumberFormatException(String invalidLottoNumber) {
        super(String.format(messageFormat, invalidLottoNumber));
    }
}
