package lotto.domain.exception;

public class NotValidLottoNumberException extends IllegalArgumentException {

    public NotValidLottoNumberException() {
        super("[ERROR] 로또 번호는 1~45 사이만 가능합니다.\n");
    }
}
