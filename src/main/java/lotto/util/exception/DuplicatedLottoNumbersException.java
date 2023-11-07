package lotto.util.exception;

public class DuplicatedLottoNumbersException extends IllegalArgumentException {
    private static final String message = "로또 번호는 중복될 수 없습니다.";

    public DuplicatedLottoNumbersException() {
        super(message);
    }
}
