package lotto.domain.lotto.exception;

/**
 * 로또 번호가 6개 미만일 때 발생할 예외
 */
public final class InvalidLottoLengthException extends IllegalArgumentException {
    public static final String INVALID_LOTTO_LENGTH_EXCEPTION_MESSAGE = "로또 번호는 반드시 6개여야 합니다.";

    public InvalidLottoLengthException() {
        super(INVALID_LOTTO_LENGTH_EXCEPTION_MESSAGE);
    }
}
