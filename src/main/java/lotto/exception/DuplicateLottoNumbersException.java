package lotto.exception;

public class DuplicateLottoNumbersException extends IllegalArgumentException {
    public DuplicateLottoNumbersException() {
        super("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }
}
