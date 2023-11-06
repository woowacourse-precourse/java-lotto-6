package model;

import java.util.List;

public class WinningNumbers extends Lotto {
    private int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers) {
        super(winningNumbers);
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        validateNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
}