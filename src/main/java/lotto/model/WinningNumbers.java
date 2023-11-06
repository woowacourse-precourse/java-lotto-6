package lotto.model;

import java.util.List;
import lotto.exception.ExistDuplicatedNumberException;

public class WinningNumbers {

    private final WinningNumber winningNumber;
    private final LottoNumber bonusNumber;

    public WinningNumbers(final WinningNumber winningNumber, final LottoNumber bonusNumber) {
        validateDuplicate(winningNumber.getNumbers(), bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(final List<LottoNumber> winningNumber, final LottoNumber bonusNumber) {
        if (hasDuplicate(winningNumber, bonusNumber)) {
            throw new ExistDuplicatedNumberException(winningNumber.toString(), bonusNumber.toString());
        }
    }

    private boolean hasDuplicate(final List<LottoNumber> winningNumber, final LottoNumber bonusNumber) {
        return winningNumber.contains(bonusNumber);
    }

    public List<LottoNumber> getWinningNumber() {
        return winningNumber.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }
}
