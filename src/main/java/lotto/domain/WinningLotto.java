package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto{
    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        validateDuplicateBonusNumber(bonusNumber);
        validateSingleNumberRange(bonusNumber);
    }

    private void validateDuplicateBonusNumber(int bonusNumber) {
        if (super.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호와 당첨 번호는 중복될 수 없습니다.");
        }
    }
}
