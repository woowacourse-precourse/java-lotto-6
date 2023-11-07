package lotto.domain;

import static lotto.domain.constants.LottoNumber.MAX_NUMBER;
import static lotto.domain.constants.LottoNumber.MIN_NUMBER;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(int bonusNumber) {
        checkDuplicateBonusNumber(bonusNumber);
        checkRangeOfBonusNumber(bonusNumber);
    }

    private void checkDuplicateBonusNumber(int bonusNumber) {
        if (getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void checkRangeOfBonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER.getValue() || bonusNumber > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}