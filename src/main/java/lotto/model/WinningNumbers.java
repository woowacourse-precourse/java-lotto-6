package lotto.model;

import java.util.List;
import lotto.exception.ExistDuplicatedNumberException;

public class WinningNumbers {

    private final WinningNumber winningNumber;
    private final LottoNumber bonusNumber;

    public WinningNumbers(final WinningNumber winningNumber, final LottoNumber bonusNumber) {
        validateDuplicate(winningNumber.getNumbers(), bonusNumber.getNumber());
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(final List<Integer> winningNumber, final int bonusNumber) {
        if (hasDuplicate(winningNumber, bonusNumber)) {
            throw new ExistDuplicatedNumberException(winningNumber, bonusNumber);
        }
    }

    private boolean hasDuplicate(final List<Integer> winningNumber, final int bonusNumber) {
        return winningNumber.contains(bonusNumber);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }
}
