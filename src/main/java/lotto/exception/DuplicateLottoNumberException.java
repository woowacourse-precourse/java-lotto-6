package lotto.exception;

public class DuplicateLottoNumberException extends IllegalArgumentException {

    public DuplicateLottoNumberException() {
        super("[ERROR] : 번호가 중복되는 로또 번호가 존재합니다.");
    }
}
