package lotto.domain;

import java.util.List;
import lotto.Lotto;
import lotto.utils.ExceptionMessage;

public class WinningNumber {

    private Lotto winningLotto;
    private int bonusNumber;

    public void createWinningNumber(List<Integer> numbers) {
        winningLotto = new Lotto(numbers);
    }

    public void creatBonusNumber(int bonusNumber) {
        validateNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    /*
    * - 보너스 번호 입력
    - [ ] 공백 입력 시 예외 발생
    - [ ] 둘 이상의 번호 입력 시 예외 발생
    - [ ] 숫자가 아닌 값 입력 시 예외 발생
    - [ ] 1 ~ 45 범위 이외의 숫자를 입력하면 예외 발생
    - [ ] 당첨 번호와 중복되면 예외 발생*/
    private void validateNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_NUMBER_RANGE);
        }
    }
}
