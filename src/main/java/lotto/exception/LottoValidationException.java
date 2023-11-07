package lotto.exception;

/**
 * 로또 유효성 검증 실패 시 발생하는 예외 클래스.
 */
public class LottoValidationException extends IllegalArgumentException {

    /**
     * 예외 메시지를 포함하여 LottoValidationException를 생성합니다.
     *
     * @param message 예외에 대한 메시지
     */
    public LottoValidationException(String message) {
        super(message);
    }
}
