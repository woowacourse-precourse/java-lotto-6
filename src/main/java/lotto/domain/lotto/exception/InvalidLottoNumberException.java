package lotto.domain.lotto.exception;

/**
 * Lotto 생성 시, 1~45 범위를 벗어나는 로또 번호가 있을 때 발생
 */
public final class InvalidLottoNumberException extends IllegalArgumentException {
    public static final String INVALID_LOTTO_NUMBER_EXCEPTION_MESSAGE = "로또 번호는 1~45 내의 숫자여야 합니다.";

    public InvalidLottoNumberException() {
        super(INVALID_LOTTO_NUMBER_EXCEPTION_MESSAGE);
    }
}
