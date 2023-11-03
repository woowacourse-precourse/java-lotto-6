package lotto.exception.lotto;

import java.util.List;

public class ExistDuplicatedNumberException extends IllegalArgumentException {

    public ExistDuplicatedNumberException(final List<Integer> numbers) {
        super("로또 번호중 중복된 값이 존재합니다. 로또 번호: " + numbers);
    }
}
