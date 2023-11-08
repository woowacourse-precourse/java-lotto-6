package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 숫자도 1~45 사이의 숫자여야합니다.");
        }
        getNumbers().stream().forEach(num -> {
            if (num == bonusNumber) {
                throw new IllegalArgumentException("보너스 숫자는 당첨번호와 겹치면 안됩니다.");
            }
        });
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
