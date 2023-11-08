package lotto;

import java.util.List;
import lotto.exception.winninglotto.WinningLottoDistinctException;
import lotto.exception.winninglotto.WinningLottoRangeException;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDistinct(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (!hasProperRange(bonusNumber)) {
            throw new WinningLottoRangeException();
        }
    }

    private void validateBonusNumberDistinct(List<Integer> winningNumbers, int bonusNumber) {
        if (containsBonusNumber(winningNumbers, bonusNumber)) {
            throw new WinningLottoDistinctException();
        }
    }

    private boolean hasProperRange(int bonusNumber) {
        return bonusNumber >= MIN_BOUND && bonusNumber <= MAX_BOUND;
    }

    private boolean containsBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        return winningNumbers.stream().anyMatch(number -> number == bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
