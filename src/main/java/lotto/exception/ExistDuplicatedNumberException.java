package lotto.exception;

import java.util.List;

public class ExistDuplicatedNumberException extends IllegalArgumentException {

    public ExistDuplicatedNumberException(final String numbers) {
        super("[ERROR] 로또 번호중 중복된 값이 존재합니다. 로또 번호: " + numbers);
    }

    public ExistDuplicatedNumberException(final String winningNumber, final int bonusNumber) {
        super("[ERROR] 당첨 숫자와 보너스 숫자 사이에 중복된 숫자가 존재합니다. 당첨 숫자: " + winningNumber + " 보너스 숫자: " + bonusNumber);
    }
}
