package lotto.exception;

public class LottoNumberOutOfRangeException extends InvalidLottoException {

    private static final String messageFormat = "유효 범위를 벗어난 로또 번호가 있습니다. 입력된 변호 : %d";

    public LottoNumberOutOfRangeException(int lottoNumber) {
        super(String.format(messageFormat, lottoNumber));
    }
}
