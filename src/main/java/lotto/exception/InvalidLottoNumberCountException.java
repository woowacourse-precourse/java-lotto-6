package lotto.exception;

public class InvalidLottoNumberCountException extends InvalidLottoException {

    private static final String messageFormat = "로또 번호의 개수가 올바르지 않습니다. 입력된 개수 : %d";

    public InvalidLottoNumberCountException(int lottoNumberCount) {
        super(String.format(messageFormat, lottoNumberCount));
    }
}
