package lotto.domain.lotto;

import java.util.List;

public class WinningLotto extends Lotto{
    private final Number bonusNumber;
    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = Number.of(bonusNumber);
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public boolean isBonusNumberIn(Lotto lotto) {
        return lotto.contain(bonusNumber);
    }
}
