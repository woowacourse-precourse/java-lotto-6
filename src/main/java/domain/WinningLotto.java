package domain;

import static config.ErrorMessage.*;

public class WinningLotto {

    private static final int FIVE_CORRECT = 5;
    private static final int BONUS_COUNT = 2;
    private Lotto numbers;
    private Integer bonusNumber;

    public void setNumbers(Lotto lotto) {
        numbers = lotto;
    }

    public void setBonusNumber(Integer bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (numbers.containsNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS.getMessage());
        }
    }

    public int countWinNumber(Lotto lotto) {
        int count = this.numbers.compareLotto(lotto);
        if (count == FIVE_CORRECT && lotto.containsNumber(bonusNumber)) {
            count += BONUS_COUNT;
        }
        return count;
    }

}
