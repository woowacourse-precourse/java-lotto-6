package lotto.domain;

import java.util.List;
import lotto.util.ErrorMessage;

public class WinningLotto{
    private final Lotto lotto;
    private final int bonusNumber;
    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if(numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE_ERROR);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
