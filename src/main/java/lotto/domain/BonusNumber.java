package lotto.domain;

import java.util.List;

public class BonusNumber {
    private final int BONUS_SIZE = 1;
    private final int bonusNumber;

    public BonusNumber(WinningNumbers winningNumbers) {
        List<Integer> bonusNumber  = winningNumbers.getWinningNumbers();
        validateBonus(bonusNumber);

        this.bonusNumber = bonusNumber.get(BONUS_SIZE-1);
    }

    private void validateBonus(List<Integer> bonusNumber) {
        if (bonusNumber.size() != BONUS_SIZE) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public boolean lottoNumbersContainBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
