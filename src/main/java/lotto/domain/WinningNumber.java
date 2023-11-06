package lotto.domain;

import java.util.List;

public class WinningNumber extends Lotto {
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        validateBonusNumberRange(bonusNumber);
        validateDuplicated(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자만 가능합니다.");
        }
    }

    private void validateDuplicated(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 포함될 수 없습니다.");
        }
    }
}
