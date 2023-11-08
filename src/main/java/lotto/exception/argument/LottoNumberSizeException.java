package lotto.exception.argument;

/**
 * 로또 숫자가 총 6개가 아닐 경우의 예외
 */
public class LottoNumberSizeException extends BaseIllegalArgumentException {
    private static final String MESSAGE = "6개의 번호를 ','로 구분하여 입력해야 합니다.";

    public LottoNumberSizeException() {
        super(MESSAGE);
    }
}
