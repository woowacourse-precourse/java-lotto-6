package lotto.exception;

import java.util.List;

public class InvalidLottoNumberException extends IllegalArgumentException {

    public InvalidLottoNumberException(final List<Integer> numbers) {
        super("[ERROR]" + numbers + "는(은) 올바르지 않은 로또 번호입니다.");
    }
}
