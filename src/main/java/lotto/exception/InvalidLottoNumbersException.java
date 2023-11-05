package lotto.exception;

public class InvalidLottoNumbersException extends IllegalArgumentException {
    private static final String INVALID_LOTTO_NUMBERS = "[ERROR] 로또 번호가 잘못 입력되었습니다.";
    public InvalidLottoNumbersException() {
        super(INVALID_LOTTO_NUMBERS);
    }
}
