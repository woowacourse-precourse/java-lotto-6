package lotto.domain.lotto.exception;

/**
 * Lotto 생성 시, 로또 번호 중복이 있을 때 발생
 */
public final class DuplicateLottoNumberException extends IllegalArgumentException {
    public static final String DUPLICATE_LOTTO_NUMBER_EXCEPTION = "중복되는 로또 번호가 존재합니다.";

    public DuplicateLottoNumberException() {
        super(DUPLICATE_LOTTO_NUMBER_EXCEPTION);
    }
}
