package lotto.exception;

public class InvalidLottoNumberException extends IllegalArgumentException {
    public InvalidLottoNumberException() {
        super("[ERROR] 로또 번호가 1 ~ 45 사이의 수가 아닙니다.");
    }
}