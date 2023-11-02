package lotto.domain.lotto.exception;

public final class InvalidLottoNumberException extends IllegalArgumentException {
    public static final String INVALID_LOTTO_NUMBER_EXCEPTION_MESSAGE = "로또 번호는 1~45 내의 숫자여야 합니다.";

    public InvalidLottoNumberException() {
        super(INVALID_LOTTO_NUMBER_EXCEPTION_MESSAGE);
    }
}
