package lotto.domain;

import java.util.List;
import lotto.constants.ErrorMessage;

public class Numbers {
    private final int bonusNumber;
    private final Lotto winningNumbers;

    public Numbers(Lotto winningNumbers, int bonusNumber) {
        Lotto.validateRange(bonusNumber);
        validateDuplication(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private static void validateDuplication(Lotto winningNumbers, int bonusNumber) {
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATE_BONUS_NUMBER);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

}
