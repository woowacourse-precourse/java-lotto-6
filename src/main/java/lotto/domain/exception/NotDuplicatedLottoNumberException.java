package lotto.domain.exception;

public class NotDuplicatedLottoNumberException extends IllegalArgumentException {
    public NotDuplicatedLottoNumberException() {
        super("[ERROR] 보너스 번호를 포함한 당첨 번호는 중복된 숫자를 포함할 수 없습니다.\n");
    }
}

